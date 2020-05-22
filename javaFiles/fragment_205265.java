scrollingContainer.addPointerReleasedListener(evt -> {
    Container cont = (Container) evt.getComponent();
    Iterator<Component> buttons = cont.iterator();
    while (buttons.hasNext()){
        Button button = (Button) buttons.next();
        if (button.getState() == Button.STATE_PRESSED) {
            button.released();
        }
    }
});