public class MyFlexTable extends FlexTable implements MouseOverHandler, HasMouseOverHandler {
    public MyFlexTable() {
        this.addMouseOverHandler(this);
    }

    public void onMouseOver(MouseOverEvent event) {
        //do something
    }
    public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
        return addDomHandler(handler, MouseOverEvent.getType());
    }
}