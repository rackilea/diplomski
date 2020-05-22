List<EventPayload> mylist=eventpojo.getEventPayload();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jcg-JPA");

        for(EventPayload array : mylist)
        {
            System.out.println("Comment Text :"+array.getCommentText());
            System.out.println("Comment Type :"+array.getCommentType());
            System.out.println("Comment Id :"+array.getCommentId());
            System.out.println("Email id :"+array.getComment_email());
            String email1=array.getComment_email();

            EntityManager em = entityManagerFactory.createEntityManager();


            List email=em.createQuery("SELECT usrinfo.user_id FROM UserInfo usrinfo WHERE usrinfo.email_id = :id").setParameter("id", email1).getResultList();
            String userid=email.get(0).toString();
            System.out.println("User id:"+userid);
            Date date = new Date();
            PageInfo pageinfo=new PageInfo();
            pageinfo.setComment_id(array.getCommentId());
            pageinfo.setComment_text(array.getCommentText());
            pageinfo.setComment_type(array.getCommentType());
            String date1=sdf.format(date);
            pageinfo.setCreation_date(sdf.parse(date1));
            pageinfo.setModification_date(sdf.parse(date1));
            pageinfo.setRetrospective_id(eventpojo.getEventRetrospectiveId());
            int user_id = Integer.parseInt(userid);
            pageinfo.setUser_id(user_id);
            EntityTransaction  trans= entityManager.getTransaction();


            trans.begin();

            em.persist(pageinfo);

            trans.commit();
            em.close();

            }

        entityManagerFactory.close();