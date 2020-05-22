public void add(LinkedList<SmsEntity> smsEntityList) {
        try {

            Session session = null;         
            session = this.sessionFactory.getCurrentSession();      
            Iterator<SmsEntity> iterator = smsEntityList.iterator();            
            while (iterator.hasNext()) {            
                session.save(iterator.next());          
            }
            session.flush();
            save(session);          
        } catch (Exception e) {
            e.printStackTrace();
        }

    }