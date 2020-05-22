Button showPaneButton = new Button(buttonPanel, SWT.PUSH);
    showPaneButton.setText("Show Pane");
    showPaneButton.addSelectionListener(new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent e) {
            this.paneThreadStarted.set(false);
            natTable.redraw();
        }
    });