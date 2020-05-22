@RequestMapping(value = "/register",method = RequestMethod.POST)
@ResponseBody
public boolean registerNewUser(@RequestBody List<User> users){
    if(users!=null){
        try {
            SessionFactory sessionFactory=HibenateConnection.connectingHibernate();
            Session session=sessionFactory.openSession();
            session.beginTransaction();
            session.save(users.get(0));
            session.getTransaction().commit();
            session.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    return false;
}