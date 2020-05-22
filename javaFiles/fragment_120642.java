@Retention(RetentionPolicy.RUNTIME)
public @interface Menu {
    String name();
    String[] children();
}

@Retention(RetentionPolicy.RUNTIME)
public @interface MenuBar {
    Menu[] value();
}

@Retention(RetentionPolicy.RUNTIME)
public @interface MenuItem {
    String value();
}

@MenuBar(
    {
        @Menu(name="File", children= {"Save","Load","Print","Preview","Quit"}),
        @Menu(name="Print", children= {"Preview","Print"}),
        @Menu(name="Edit", children= {"Copy","Paste"})
    }
)
public class TestMenu {
    @MenuItem ("Save")
    public void save() {
        System.out.println("saved");
    }

    @MenuItem ("Load")
    public void load() {
        System.out.println("loaded");
    }
}