public class MyUI extends UI {
    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();
        setContent(content);

        content.addComponent(new TextField());
        content.addComponent(new Button("Switch theme", e -> {
            if (getTheme().equals("mytheme1")) {
                setTheme("mytheme2");
            } else {
                setTheme("mytheme1");
            }
        }));
    }
}