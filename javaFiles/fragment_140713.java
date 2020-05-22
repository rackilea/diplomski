public GraphExample(JFrame parent,String title) {
    super(parent,title);
    setPreferredSize(new Dimension(500, 500));
    this.setModal(true);
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    pack();
    setVisible(true);
}