@Override
    public void onPreviewDrop(DragContext context)
        throws VetoDragException {
    super.onPreviewDrop(context);

    int newIndex = -1;
    String positionerClass = newPositioner(context).getElement()
        .getClassName();
    for (int i = 0; i < dropTarget.getWidgetCount(); i++) {
        String widgetClass = dropTarget.getWidget(i).getElement()
            .getClassName();
        if (widgetClass.equals(positionerClass)) {
        newIndex = i;
        }
    }
   };