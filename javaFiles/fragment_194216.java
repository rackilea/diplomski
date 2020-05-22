/* save datalist */
public void save() {
    Session session = nlul;
    try {
        session = DaoSF.getSessionFactory.openSession();
        /* one instance per call, 
         * ready for garbage collection after leaving this method
         */
        Dao mydao = new Dao(session);
        mydao.save(dataList);
    } catch  (Exception e) {...
    } finally {
        if (sessioN != null)
            session.close();
    }
}