pm = yourPMfactory.getPersistenceManger();
Course c = new Course();
Document d = new Document();
c.document = d;
pm.makePersistent(c);

Key myKey = c.getKey();
Course c2 = (Course) pm.getObjectById(Course.class, myKey.getId());
assertTrue(c.document != null); //or however your favorite test suite does assertions.
pm.close();