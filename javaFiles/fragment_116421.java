List<User> userList = new ArrayList<User>();

        try {
            session = HibernateUtil.getSession();
            String hql = "select new User(user.id, user.firstName, user.address.id, user.address.state " 
                    + "from User user where user.id in (:userIdList) ";
            Query q = session.createQuery(hql);
            q.setParameterList("userIdList",userIdList);
            userList=q.list();
            session.flush();
        }