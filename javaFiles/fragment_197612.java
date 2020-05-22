private class BorderFaker extends JPanel
{
  public BorderFaker()
  {
    add( new JButton( "Faked!" ) );
  }

  @Override
  public void paintComponent( Graphics g )
  {
    super.paintComponent( g );
    drawFauxBorder( g );
  }

  private void drawFauxBorder( Graphics g )
  {
    g.setColor( UIManager.getColor( "border" ) );
    g.drawRect( 15, 15, getWidth() - 30, getHeight() - 30 );
  }
}