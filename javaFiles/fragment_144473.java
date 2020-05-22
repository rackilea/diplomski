public class DatabaseBackupJob implements Job {
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        Session session = cfg.buildSessionFactory().openSession();
        Query q = session.createQuery("insert into Tab_Transaction_History(trans) select t.trans as trans from Tab_Transaction t where t.date < :date")
        .setParameter("date", reqDate);
        try{
           Trasaction t = session.beginTransaction();
           q.executeNonQuery();
           t.commit();
        } catch(Exception e){
        } finally {
           session.close();
        }
    }

}