@com.vaadin.annotations.JavaScript("main.js")
public class QwertUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = QwertUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        final Table table = new Table("The Brightest Stars");

        table.addContainerProperty("Name", String.class, null);
        table.addContainerProperty("Mag",  Float.class, null);

        Object newItemId = table.addItem();
        Item row1 = table.getItem(newItemId);
        row1.getItemProperty("Name").setValue("Sirius");
        row1.getItemProperty("Mag").setValue(-1.46f);

        // Add a few other rows using shorthand addItem()
        table.addItem(new Object[]{"Canopus",        -0.72f}, 2);
        table.addItem(new Object[]{"Arcturus",       -0.04f}, 3);
        table.addItem(new Object[]{"Alpha Centaurissssssssssssssssssssssssssssssssssssssssssss", -0.01f}, 4);
        JavaScript.getCurrent().addFunction("YouAreWelcome", new JavaScriptFunction(){
            @Override
            public void call(JsonArray arguments)
            {
                Object o = arguments.get(0).asString();
                table.setColumnWidth("Name", new Integer(o.toString()));
            }
        });
        JavaScript.getCurrent().execute("WeChooseToGoToTheMoon()");
        table.setPageLength(table.size());
        layout.addComponent(table);
    }

}