public MainFrame() {
    PeriodFormPanel periodFormPanel = new PeriodFormPanel();
    this.setJMenuBar(periodFormPanel.getMenuBar());
    this.setContentPane(periodFormPanel);
    this.pack();

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   this.setVisible(true);