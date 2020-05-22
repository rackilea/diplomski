((EventTarget) ele).addEventListener("keydown", new EventListener() {

    @Override
    public void handleEvent(Event evt) {
        System.out.println(String.valueOf(((com.sun.webkit.dom.KeyboardEventImpl) evt).getKeyCode()));
        com.sun.webkit.dom.KeyboardEventImpl event = (com.sun.webkit.dom.KeyboardEventImpl) evt;
        System.out.println(event.getKeyIdentifier());
    }
}, false);