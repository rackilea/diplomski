class MyDialogBox extends DialogBox {
        private TextBox textBox = new TextBox();
        private Button okButton = new Button("Ok");

        public MyDialogBox(Label label) {
            super();
            setText("My Dialog Box");
            final Label l = label;
            okButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    hide();
                    l.setText(textBox.getText());
                }
            });
            VerticalPanel vPanel = new VerticalPanel();
            vPanel.add(textBox);
            vPanel.add(okButton);
            setWidget(vPanel);
        }
    }