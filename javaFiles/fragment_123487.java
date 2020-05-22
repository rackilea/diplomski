private static int displayFontPanel(JFrame w){
      JFrame window = new JFrame("Font Settings");
      window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      JPanel panel = new JPanel();
      panel.setLayout(new BorderLayout());
      final AtomicInteger fontSize = new AtomicInteger(14);
      window.setSize(400, 200);
      window.setLocationRelativeTo(w);
      JSlider fntSize = new JSlider(8,40,20);
      fntSize.addChangeListener(new ChangeListener()   {
        public void stateChanged(ChangeEvent evt) {
            fontSize.set(((JSlider)evt.getSource()).getValue());
        }
      });
      fntSize.setLabelTable( fntSize.createStandardLabels(8) );
      fntSize.setPaintLabels(true);
      panel.add(fntSize, BorderLayout.CENTER);
      window.setContentPane(panel);
      window.setVisible(true);
      return fontSize.get();
}