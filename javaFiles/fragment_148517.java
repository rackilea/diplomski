ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
if (sessionFactory == null) {
    System.out.println("SessionFactory obj is null");
} else {
    Session session = sessionFactory.openSession();
    System.out.println("Session obj: " + session);
    System.out.println("isOpen: " + session.isOpen() + "  isConnected: " + session.isConnected());
    session.close();
}