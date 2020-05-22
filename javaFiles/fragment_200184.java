class PersonAction extends AbstractAction {
    private Person person;

    public PersonAction(Person person) {
        super(person.getName());
        this.person = person;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StringSelection stringSelection = new StringSelection(person.getIdentification());

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}