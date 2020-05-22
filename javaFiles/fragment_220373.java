@Route
@JavaScript("/frontend/js/dropzone.js")
@StyleSheet("/frontend/js/dropzone.css")
public class MainView extends VerticalLayout {

    private MainView() {

        add(new H1("Vaadin Spring Dropzone"));

        add(new H2("Default adding method"));
        Element form = new Element("form");
        form.setAttribute("action", "uploadwsdl");
        form.setAttribute("class", "dropzone dz-clickable");
        form.setAttribute("id", "wsdlUpload");
        getElement().appendChild(form);
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        UI.getCurrent().getPage().executeJavaScript("Dropzone._autoDiscoverFunction()");
    }

}