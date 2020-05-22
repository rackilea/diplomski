@Root(name = "parent")
public class Parent
{
    @ElementList(name = "childs", required = true)
    private List<Child> childs;


    public Parent()
    {
        this.childs = new ArrayList<>();
    }



    public void addChild(Child child)
    {
        childs.add(child);
    }

    // ...
}