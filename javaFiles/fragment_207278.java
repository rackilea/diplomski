public class PersonExample{
    public static void main(String[] args) {
        Session session = null;
        try {
            SessionFactory sessionFactory = new Configuration().configure()
                    .buildSessionFactory();
            session = sessionFactory.openSession();
            System.out.println("Starting select");
            List<Person> persons= session.createSQLQuery("select {p.*} from Person p").addEntity("p", Person.class).list();
            for (Iterator<Person> it = persons.iterator(); it.hasNext();) {
            Person stObject = it.next();
               System.out.println("ID: " + stObject.getId());
               System.out.println("Surname: " + stObject.getSurname());
               System.out.println("Name: " + stObject.getName());
               System.out.println("Address: " + stObject.getAddress());
            }
            System.out.println("Finished select");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            // Actual contact insertion will happen at this step
            session.flush();
            session.close();
        }

    }
}