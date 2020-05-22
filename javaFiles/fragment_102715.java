public void showStack(int index) {

    if ((index >= getWidgetCount()) || index < 0) {
       return;
    }

    visibleStack = index;
    setStackVisible(visibleStack, !getWidget(visibleStack).isVisible());


  }