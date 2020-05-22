scale.addListener(SWT.Selection, new Listener() {
    public void handleEvent(Event event) {
        // get the current selection and "round" it to the next 5er step
        int scaleValue = scale.getSelection();
        scaleValue = (int)(Math.round(scaleValue / 5.0) * 5);

        // update the label
        label.setText("" + (scaleValue));
        label.pack();

        // update the scale selection
        scale.setSelection(scaleValue);
    }
});