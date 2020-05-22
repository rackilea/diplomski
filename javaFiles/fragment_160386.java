public class DragFlexTable extends FlexTable implements
            MouseDownHandler,MouseUpHandler,MouseMoveHandler,
            MouseOutHandler
{
    private int row,column,draggedrow,draggedcolumn;
    private Element td;
    private Widget w;
    private boolean emptycellclicked;
    DragFlexTable()
    {
        sinkEvents(Event.ONMOUSEOVER | Event.ONMOUSEOUT | Event.ONMOUSEDOWN | Event.ONMOUSEMOVE);
        this.addMouseDownHandler(this);
        this.addMouseMoveHandler(this);
        this.addMouseUpHandler(this);
        this.addMouseOutHandler(this);
    }
    @Override
    public void onBrowserEvent(Event event)
    {
        super.onBrowserEvent(event);
        td = getEventTargetCell(event);
        if (td == null)
        {
            return;
        }
        Element tr = DOM.getParent((com.google.gwt.user.client.Element) td);
        Element body = DOM.getParent((com.google.gwt.user.client.Element) tr);
        row = DOM.getChildIndex((com.google.gwt.user.client.Element) body, (com.google.gwt.user.client.Element) tr);//(body, tr);
        column = DOM.getChildIndex((com.google.gwt.user.client.Element) tr, (com.google.gwt.user.client.Element) td);
    }
    boolean mousedown;
    @Override
    public void onMouseDown(MouseDownEvent event)
    {
        if (event.getNativeButton() == NativeEvent.BUTTON_LEFT)
        {
            //to ensure empty cell is not clciked
            if (!td.hasChildNodes())
            {
                emptycellclicked = true;
            }
            event.preventDefault();
            start(event);
            mousedown = true;
        }
    }
    @Override
    public void onMouseMove(MouseMoveEvent event)
    {
        if (mousedown)
        {
            drag(event);
        }
    }
    @Override
    public void onMouseUp(MouseUpEvent event)
    {
        if (event.getNativeButton() == NativeEvent.BUTTON_LEFT)
        {
            if (!emptycellclicked)
            {
                end(event);
            }
            emptycellclicked = false;
            mousedown = false;
        }
    }
    @Override
    public void onMouseOut(MouseOutEvent event)
    {
        this.getCellFormatter().getElement(row, column).getStyle().clearBorderStyle();
        this.getCellFormatter().getElement(row, column).getStyle().clearBorderColor();
        this.getCellFormatter().getElement(row, column).getStyle().clearBorderWidth();
        w.getElement().getStyle().setOpacity(1);
        mousedown = false;
    }
    private void start(MouseDownEvent event)
    {
        w = this.getWidget(row, column);
        w.getElement().getStyle().setOpacity(0.5);
    }
    private void drag(MouseMoveEvent event)
    {
        if (draggedrow != row || draggedcolumn != column)
        {
            this.getCellFormatter().getElement(draggedrow, draggedcolumn).getStyle().clearBorderStyle();
            this.getCellFormatter().getElement(draggedrow, draggedcolumn).getStyle().clearBorderColor();
            this.getCellFormatter().getElement(draggedrow, draggedcolumn).getStyle().clearBorderWidth();
            this.draggedrow = row;
            this.draggedcolumn = column;
            this.getCellFormatter().getElement(row, column).getStyle().setBorderStyle(BorderStyle.DASHED);
            this.getCellFormatter().getElement(row, column).getStyle().setBorderColor("black");
            this.getCellFormatter().getElement(row, column).getStyle().setBorderWidth(2, Unit.PX);
        }
    }
    private void end(MouseUpEvent event)
    {
        insertDraggedWidget(row, column);
    }
    private void insertDraggedWidget(int r,int c)
    {
        this.getCellFormatter().getElement(r, c).getStyle().clearBorderStyle();
        this.getCellFormatter().getElement(r, c).getStyle().clearBorderColor();
        this.getCellFormatter().getElement(r, c).getStyle().clearBorderWidth();
        w.getElement().getStyle().setOpacity(1);
        if (this.getWidget(r, c) != null)
        {
            //pushing down the widgets already in the column 
            //          int widgetheight = (this.getWidget(r, c).getOffsetHeight() / 2) + this.getWidget(r, c).getAbsoluteTop();
            //          int rw;
            //placing the widget above the dropped widget
            for (int i = this.getRowCount() - 1; i >= r; i--)
            {
                if (this.isCellPresent(i, c))
                {
                    this.setWidget(i + 1, c, this.getWidget(i, c));
                }
            }
        }
        this.setWidget(r, c, w);
        //removes unneccesary blank rows 
        cleanupRows();
        //pushing up the column in the stack
        //      for (int i = oldrow;i<this.getRowCount()-1 ;i++)
        //      {
        //          
        //              this.setWidget(i ,oldcolumn, this.getWidget(i+1, oldcolumn));
        //          
        //      }
    }
    private void cleanupRows()
    {
        ArrayList<Integer> rowsfilled = new ArrayList<Integer>();
        for (int i = 0; i <= this.getRowCount() - 1; i++)
        {
            for (int j = 0; j <= this.getCellCount(i) - 1; j++)
            {
                if (this.getWidget(i, j) != null)
                {
                    rowsfilled.add(i);
                    break;
                }
            }
        }
        //replace the empty rows
        for (int i = 0; i < rowsfilled.size(); i++)
        {
            int currentFilledRow = rowsfilled.get(i);
            if (i != currentFilledRow)
            {
                for (int j = 0; j < this.getCellCount(currentFilledRow); j++)
                {
                    this.setWidget(i, j, this.getWidget(currentFilledRow, j));
                }
            }
        }
        for (int i = rowsfilled.size(); i < this.getRowCount(); i++)
        {
            this.removeRow(i);
        }
    }
    public HandlerRegistration addMouseUpHandler(MouseUpHandler handler)
    {
        return addDomHandler(handler, MouseUpEvent.getType());
    }
    public HandlerRegistration addMouseDownHandler(MouseDownHandler handler)
    {
        return addDomHandler(handler, MouseDownEvent.getType());
    }
    public HandlerRegistration addMouseMoveHandler(MouseMoveHandler handler)
    {
        return addDomHandler(handler, MouseMoveEvent.getType());
    }
    public HandlerRegistration addMouseOutHandler(MouseOutHandler handler)
    {
        return addDomHandler(handler, MouseOutEvent.getType());
    }
}