for (int i = 0; i < columns; i++) {
    Composite column = new Composite(numbersComposite, SWT.NONE);
    column.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

    GridLayout columnLayout = new GridLayout();
    column.setLayout(columnLayout);

    for (int j = 0; j < rows; j++) {
        Button button = new Button(column, SWT.TOGGLE);
        button.setText(Integer.toString(number));

        button.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        buttons.add(button);

        number++;
    }
}