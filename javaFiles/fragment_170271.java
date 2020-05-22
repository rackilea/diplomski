this.content.addPropertyChangeListener("page",
    new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent event) {
            System.out.println("getText() on JTextPane gives "
                + content.getText());
        }
    });

this.content.setPage(helpURL);