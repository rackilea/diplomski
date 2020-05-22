@Theme("mytheme")
public class MyUI extends UI {

@Override
protected void init(VaadinRequest vaadinRequest) {
    final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    layout.setSpacing(true);
    setContent(layout);

    //cache the beans
    ArrayList<MyBean> beans = getBeans();

    BeanItemContainer container = new BeanItemContainer<>(MyBean.class, beans);

    Table table = new Table();
    table.setSelectable(true);
    table.setImmediate(true);
    table.setWidth("200px");
    table.setPageLength(5);

    table.setContainerDataSource(container);

    //select programmatically
    table.select(beans.get(1));//this is the key idea! Provide the same bean from cache, for selection.

    layout.addComponent(table);
}

@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
public static class MyUIServlet extends VaadinServlet {
}

public class MyBean {

    private int id;
    private String field;

    public MyBean(int id, String field) {
        this.id = id;
        this.field = field;
    }

    public int getId() {
        return id;
    }

    public String getField() {
        return field;
    }

}

public ArrayList<MyBean> getBeans() {
    ArrayList<MyBean> beans = new ArrayList<>();

    MyBean bean = new MyBean(1, "Vikrant");
    beans.add(bean);

    bean = new MyBean(2, "John");
    beans.add(bean);

    bean = new MyBean(3, "Rahul");
    beans.add(bean);

    return beans;
}