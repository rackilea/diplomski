private void initComponents() {


        Border emptyBorder = BorderFactory.createEmptyBorder();
        final TitledBorder characterCountTitle = BorderFactory.createTitledBorder(emptyBorder, "Character Count:");
        characterCountTitle.setTitlePosition(TitledBorder.BOTTOM);
        panel.setBorder(characterCountTitle);

        this.notePanel.getNoteDocument().addDocumentListener(new DocumentListener()                 {

        public void insertUpdate(DocumentEvent e) {
            displayEditInfo(e);
        }

        public void removeUpdate(DocumentEvent e) {
            displayEditInfo(e);
        }

        public void changedUpdate(DocumentEvent e) {
            displayEditInfo(e);
        }

        private void displayEditInfo(DocumentEvent e) {
            Document document = e.getDocument();


            //displays a string and dynamic character count
            characterCountTitle.setTitle("Character Count: " +  document.getLength());
            panel.repaint();

        }
    });

    this.panel.add(notePanel, BorderLayout.CENTER);
    this.panel.add(navigation.buildPanel(), BorderLayout.SOUTH);
}