@Before
public void setup()
{
    context= new GenericXmlApplicationContext("/context.xml");
    hello = context.getBean("hello", Hello.class);
    hellosub=context.getBean("helloSub", Hello.class);
}