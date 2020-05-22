public class TestPane extends JPanel {

    private JList listOfStuff;

    public TestPane() {
        setLayout(new BorderLayout());
        listOfStuff = new JList();
        add(new JScrollPane(listOfStuff));

        CopyAction copyAction = new CopyAction(listOfStuff);
        listOfStuff.getActionMap().put("copy", copyAction);
    }

    public JList getListOfStuff() {
        return listOfStuff;
    }

}