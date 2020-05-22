public TesingSpinner() {
    model = new SpinnerNumberModel(0.00, -1000.0, 1000.0, 0.01);
    jSpinner1 = new JSpinner(model);
    editor = new JSpinner.NumberEditor(jSpinner1);
    jSpinner1.setEditor(editor);
    initComponents();
}