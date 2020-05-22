int delay = 3000;
Timer timer = new Timer( delay, new ActionListener(){
  @Override
  public void actionPerformed( ActionEvent e ){
      yourFrame.dispose();
      Dashboard mydash = new Dashboard();
      mydash.setVisible(true);
  }
});
timer.setRepeats(false);
timer.start();