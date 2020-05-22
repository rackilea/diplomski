/**
 * Change the vertical alignment.
 * @param align possible values : -1 or 1
 */
public native final void setVerticalAlignment(int align) /*-{
    this.vAxis.direction = align;
}-*/;