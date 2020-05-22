public void init() {
   setLayout(new CardLayout());

   JPanel startPanel = new JPanel();
   okButton = new JButton("Press");
   startPanel.add(okButton);
   ...
   add(startPanel, "Card 1");
   ...
}