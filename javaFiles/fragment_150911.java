public URLBar(String text, EditorPane pane) {

    super(text);

    this.pane = pane; // add this
     addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                loadContent(event.getActionCommand());
            }
        }
     );
}