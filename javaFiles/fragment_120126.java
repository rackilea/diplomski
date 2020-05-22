MyBean x = new MyBean();
x.addListener(new Listener("typedA") {
    public <T> void propertyChanged(final String p,
                 final T oldValue, final T newValue) {
        System.out.println(p + " changed: " + oldValue + " to " + newValue);
        // TODO
    }
});

x.setTypedA(true);
x.setTypedA(false);
x.setTypedA(true);
x.setTypedA(true);