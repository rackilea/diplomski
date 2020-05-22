public String getCustomerEmail(){
        Session session = HibernateSessionFactory.getSession();
        //Session session = sessionFactory.openSession();
        String maxOrderNoDay = "";
        try{
            maxOrderNoDay = (String) session.createQuery("select cus.mail from Customer cus join cus.mainOrder man WHERE man.id = 1").uniqueResult();
            //
            System.out.println(maxOrderNoDay);

        }catch(HibernateException e){
            e.printStackTrace();
        }finally{
            session.close();
            return  maxOrderNoDay;
        }
    }