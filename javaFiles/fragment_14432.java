@Override
protected void endDragging(MouseUpEvent event)
{
    //Move dialog window behind top border
    if(this.getAbsoluteTop() < 0) {
        this.setPopupPosition(this.getPopupLeft(), 0);
    }
    //Move dialog window behind bottom border
    if(this.getAbsoluteTop() > (Window.getClientHeight() - this.getOffsetHeight())) {
        this.setPopupPosition(this.getPopupLeft(), Window.getClientHeight() - this.getOffsetHeight());
    }

    //Move dialog window behind left border
    if(this.getAbsoluteLeft() < 0) {
        this.setPopupPosition(0, this.getPopupTop());
    }
    //Move dialog window behind right border
    if(this.getAbsoluteLeft() > (Window.getClientWidth() - this.getOffsetWidth())) {
        this.setPopupPosition(Window.getClientWidth() - this.getOffsetWidth(), this.getPopupTop());
    }
    super.endDragging(event);
}