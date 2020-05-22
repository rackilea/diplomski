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

        ComboBox combo = new ComboBox("My Combo");              
        combo.setItemCaptionMode(AbstractSelect.ItemCaptionMode.PROPERTY);
        combo.setItemCaptionPropertyId("field");
        combo.setContainerDataSource(container);

        //select programmatically
        combo.select(beans.get(1));//this is the key idea! Provide the same bean from cache, for selection.

        layout.addComponent(combo);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

    public class MyBean {

        private final int id;
        private final String field;

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