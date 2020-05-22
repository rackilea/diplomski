JFormattedTextField multiplex = new JFormattedTextField() {
    KeyStroke enter = KeyStroke.getKeyStroke("ENTER");
    @Override
    protected boolean processKeyBinding(KeyStroke ks, KeyEvent e,
                                        int condition, boolean pressed) {
        boolean processed = super.processKeyBinding(ks, e, condition,
                                                    pressed);

        if (processed && condition != JComponent.WHEN_IN_FOCUSED_WINDOW
                && enter.equals(ks)) {
            // Returning false will allow further processing
            // of the bindings, eg our parent Containers will get a
            // crack at them and f.i. route to a default button.
            return !isEditValid();
        }
        return processed;
    }

};
multiplex.setValue(new Date());