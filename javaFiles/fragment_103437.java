public static void updateSubjectRank(String subject, String extype, int academicyear, int semester, int level) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            double[] scores = getSubjectScores(subject, extype, academicyear, semester, level);
            int[] ranks = Rank.getRank(scores);
            for (double d : scores) {
                Criteria cr = session.createCriteria(EduResults.class);
                int rank = Rank.getRank(Rank.getRank(scores), Rank.getArrayIndex(scores, d)) + 1;
                cr.add(Restrictions.eq("subject", subject));
                cr.add(Restrictions.eq("extype", extype));
                cr.add(Restrictions.eq("acedemicyear", academicyear));
                cr.add(Restrictions.eq("semester", semester));
                cr.add(Restrictions.eq("level", level));
                cr.add(Restrictions.eq("scorePcnt", d));
                ScrollableResults items = cr.scroll();
                int count = 0;
                while (items.next()) {
                    EduResults res = (EduResults) items.get(0);
                    res.setSubjectRank(rank);
                    System.out.println(rank);
                    session.saveOrUpdate(res);
                    if (++count % 100 == 0) {
                        session.flush();
                        session.clear();
                    }
                }
            }

            tx.commit();
        } catch (Exception asd) {
            log.debug(asd.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }