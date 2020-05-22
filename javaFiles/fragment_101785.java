import org.stringtemplate.v4.*;

public class Test {

    public static void main(String[] args) {
        STGroup stGroup = new STGroupFile("testGroup.stg");
        ST st = stGroup.getInstanceOf("test");
        stGroup.registerRenderer(String.class, new StringRenderer());
        st.add("text", "helloWorld"); // note lower case 'h'
        System.out.println(st.render());
    }
}