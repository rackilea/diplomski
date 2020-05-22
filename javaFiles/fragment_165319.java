public MainScreen() {
    JPanel mainPanel = new JPanel(new BorderLayout());
    this.setLayout(new BorderLayout());                  <----
    setBtnPanelAndComp();
    setIconPanelAndComp();
    add(mainPanel);
}