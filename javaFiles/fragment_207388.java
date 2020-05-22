public class WindowWithResizeListener extends Window implements Button.ClickListener, Window.ResizeListener {

    public WindowWithResizeListener() {
        center();
        setWidth(600, Unit.PIXELS);
        setHeight(430, Unit.PIXELS);
        setModal(true);
        setResizable(true);
        setImmediate(true);
        addResizeListener(this);
    }

    @Override
    public void windowResized(ResizeEvent resizeEvent) {
        Notification.show("Resized!");

    }

    @Override
    public void buttonClick(Button.ClickEvent clickEvent) {

    }
}