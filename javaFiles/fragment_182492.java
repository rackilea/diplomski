btnBookFlight.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent event) {

      JButton button = (JButton)event.getSource();
      button.setBackground(Color.RED);
      ...
    }
});