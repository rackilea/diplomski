@Root()
public class X {

    @ElementList (inline=true, entry="a")
    private List<String> aList= null;

    Element(name="b")
    protected String b;

    Element(name="c")
    protected String c;
}