checkBox.addSelectionListener(new SelectionAdapter() {

        @Override
        public void widgetSelected(SelectionEvent event) {
            Button btn = (Button) event.getSource();
            System.out.println(btn.getSelection());
        }
    });