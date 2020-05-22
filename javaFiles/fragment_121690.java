private Button createButton(Button buttonToCreate, String buttonText, int height, int width, FormAttachment left, FormAttachment top, Runnable actionOnSelection) {

  // ...
    buttonToCreate.addSelectionListener(new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent e) {
            actionOnSelection.run(); // change here
        }
    });
}