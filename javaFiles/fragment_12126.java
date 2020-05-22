public NotesPanel(Note note){
    this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    JLabel creatorLabel = new JLabel("Note by "+note.getCreator()+ " @ "+note.getDateCreated());
    creatorLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
    creatorLabel.setHorizontalAlignment(JLabel.LEFT);


    JTextArea notesContentsArea = new JTextArea(note.getContents());
    notesContentsArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(notesContentsArea);
    scrollPane.setAlignmentX(JScrollPane.LEFT_ALIGNMENT);

    JLabel editorLabel = new JLabel(" -- Last edited by "+note.getLastEdited() +" at "+note.getDateModified());
    editorLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
    editorLabel.setHorizontalAlignment(JLabel.LEFT);

    this.add(creatorLabel);
    this.add(scrollPane);
    this.add(editorLabel);
    this.setBorder(new BevelBorder(BevelBorder.RAISED));
}