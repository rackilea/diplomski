AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenceContext.class);
SessionFactory sessionFactory = context.getBean(SessionFactory.class);
Session session = sessionFactory.openSession();

TimeFields timeFields = new TimeFields();
Date date = new Date();
DateTime dateTime = new DateTime();
System.out.println(date);
System.out.println(dateTime);
timeFields.setDate(date);
timeFields.setDateTime(dateTime);

session.beginTransaction();
session.persist(timeFields);
session.getTransaction().commit();

System.out.println(timeFields.getTimeId());
System.out.println(timeFields.getDate());
System.out.println(timeFields.getDateTime());