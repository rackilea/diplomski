((EventTarget) ele).addEventListener("keydown", (event) -> {
    //if triggering key is 'ENTER'
    System.out.println(event.toString());
    if ("Enter".contentEquals(((com.sun.webkit.dom.KeyboardEventImpl) event).getKeyIdentifier())) {
        System.out.println("keydown on Enter");
    }
}, false);