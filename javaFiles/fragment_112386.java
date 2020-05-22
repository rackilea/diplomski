AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

ctx.register(DBConfiguration.class);
ctx.refresh();

Dao dao = ctx.getBean(Dao.class);