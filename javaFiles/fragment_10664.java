Window window = new Window();
    Calendar calendar = new Calendar("Calendar");
    calendar.setWidth("100%");
    window.setWidth("700px");
    window.setHeight("450px");
    window.setContent(calendar);
    window.addWindowModeChangeListener(event -> Page
            .getCurrent()
            .getJavaScript()
            .execute("setTimeout(function() { vaadin.forceLayout(); }, 150);"));
    Button button = new Button("Click me", event -> UI.getCurrent().addWindow(window));
    setContent(button);