@Root(...)
public class House
{
    @ElementList(inline = true, ...)
    private List<MainLevel> levels;

    // ...
}

public class MainLevel
{
    @Attribute(name = "Name")
    private String name;
    @Attribute(name = "IsHidden")
    private bool hidden;
    @ElementList(inline = true, ...)
    private List<ChildLevel> childLevels;

    // ...
}

public class ChildLevel
{
    @Attribute(name = "Name")
    private String name;
    @Attribute(name = "Category", required = false)
    private String category;

    // ...
}