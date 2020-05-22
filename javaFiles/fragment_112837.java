@Override
protected void paintComponent(Graphics g)
{ 
   // paint the component as opaque
   setOpaque(true);
   super.paintComponent(g);
   setOpaque(false);
}