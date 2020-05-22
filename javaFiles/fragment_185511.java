itemList.addKeyListener(new KeyAdapter() {
    public void keyReleased(KeyEvent e) {
        if (e.keyCode == '\r' || e.keyCode == SWT.KEYPAD_CR) {
            okButtonAction();
        } else if (e.keyCode == SWT.ARROW_UP || e.keyCode == SWT.ARROW_DOWN || e.keyCode == SWT.ARROW_LEFT || e.keyCode == SWT.ARROW_RIGHT) {
            super.keyReleased(e);
        } else if (e.character > 0) {
            filterInput.setFocus();
            Event event = new Event();
            event.type = SWT.KeyDown;
            event.keyCode = e.keyCode;
            event.character = e.character;                  
            Display.getCurrent().post(event);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            event.type = SWT.KeyUp;
            Display.getCurrent().post(event);
        }
    }
});