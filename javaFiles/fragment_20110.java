public static void main(String[] args) throws UnknownHostException
{
    ApplicationContext ctx = SpringApplication.run(NewClass.class, args);
    MongoTemplate mongoTemplate = ctx.getBean(MongoTemplate.class);
    MyClass myClass = new MyClass();
    mongoTemplate.save(myClass);
    MyClassRepository myClassRepository = ctx.getBean(MyClassRepository.class);
    myClassRepository.save(myClass);
}