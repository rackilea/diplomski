public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            JFrame mainFrame = new JFrame("Muney Manager");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Setting up panels:
            JPanel mPanel = new JPanel();
            mPanel.setLayout(new BorderLayout());

            TablePanel tPanel = new TablePanel();
            ToolBar buttonPanel = new ToolBar(tPanel);

            mPanel.add(buttonPanel, BorderLayout.NORTH);
            mPanel.add(tPanel);

            //Setting up Panels and Frame to be displayed :3
            mainFrame.getContentPane().add(mPanel);
            mainFrame.pack();
            mainFrame.setVisible(true);
        }
    });
}