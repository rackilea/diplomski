public void showStack(int index) {
    if ((index >= getWidgetCount()) || (index < 0) || (index == visibleStack)) {
      return;
    }

    if (visibleStack >= 0) {
      setStackVisible(visibleStack, false);
    }

    visibleStack = index;
    setStackVisible(visibleStack, true);    }