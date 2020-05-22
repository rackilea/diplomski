@SpringUI(path = "/ui")
public class MyUI extends UI {

@Override
protected void init(VaadinRequest request) {
    Panel panel = new Panel();
    panel.addStyleName(ValoTheme.PANEL_BORDERLESS);
    panel.setSizeFull();

    VerticalLayout layout = new VerticalLayout();
    // by default width 100% and height undefined in Vaadin 8
    panel.setContent(layout);

    // component A
    Label label = new Label("Test1");
    layout.addComponent(label);

    // component B
    HorizontalLayout bar = new HorizontalLayout();
    bar.addComponents(new Label("Label 1"), new Label("Label 2"));
    layout.addComponent(bar);

    // component C
    Grid<MyBean> grid = new Grid<>(MyBean.class);
    grid.setCaption("My Grid:");
    grid.setHeight("1000px");
    //grid.setHeightByRows(50); // same as fixed height
    List<MyBean> items = new LinkedList<>();
    IntStream.range(1, 100).forEach(i -> items.add(new MyBean("Item " + i)));
    grid.setItems(items);
    layout.addComponent(grid);

    setContent(panel);
}

public static class MyBean {
    private String name;
    public MyBean(String name) { this.name = name; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

}