public class RowWidgetExpander extends RowExpander {

private Widget widget;

public void setWidget(Widget widget) {
    this.widget = widget;
}

public Widget getWidget() {
    return widget;
}

@Override
protected boolean beforeExpand(ModelData model, Element body, El row, int rowIndex) {
    RowExpanderEvent e = new RowExpanderEvent(this);
    e.setModel(model);
    e.setRowIndex(rowIndex);
    e.setBodyElement(body);

    if(fireEvent(Events.BeforeExpand, e)) {
        body.setInnerText("");
        body.appendChild(widget.getElement());
        ComponentHelper.doAttach(widget);

        return true;
    }

    return false;
}