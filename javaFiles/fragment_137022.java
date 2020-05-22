public class MyPanelFactory {
    public MyBasePanel myBasePanel() {
        MyBasePanel myBasePanel = new MyBasePanel();
        initMyBasePanel(myBasePanel);
        return myBasePanel;
    }

    public MyDerivedPanel myDerivedPanel() {
        MyDerivedPanel myDerivedPanel = new MyDerivedPanel();
        initMyBasePanel(myDerivedPanel);
        return myDerivedPanel;
    }

    private void initMyBasePanel(MyBasePanel myBasePanel) {
        myBasePanel.add(new JLabel("My label"), BorderLayout.CENTER);
    }
}