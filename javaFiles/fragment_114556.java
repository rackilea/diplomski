public class Test {

    @XStreamAlias("name")
    @XStreamAsAttribute
    private String name;

    @XStreamAlias("good")
    @XStreamAsAttribute
    private boolean good;

    public Test(String name, boolean good){
        this.name = name;
        this.good = good;
    }

    public static void main(String[] args) {
        XStream stream = new XStream();
        stream.processAnnotations(new Class[] {Test.class});
        stream.registerConverter(new MyBooleanConverter());

        Test test1 = new Test("Test", true);
        System.out.println(stream.toXML(test1));
        Test test2 = new Test("Test", false);   
        System.out.println(stream.toXML(test2));    
    }
}