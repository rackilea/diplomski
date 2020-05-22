public void actionPerformed(ActionEvent e)
{
  if (((JButton) e.getSource()).getText().equals("Click to Play")) {
    removeAll();
    setBackground(Color.pink);
    InitializeGame();
  }

  if ( e.getActionCommand().equals( "s1" ) )
  {
    ((JButton)e.getSource()).setText("X");
  }

  repaint();
}