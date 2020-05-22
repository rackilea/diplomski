@Override
public void paint(Graphics g){
    // calls paint from higher up the inheritance tree
    super.paint(g); 
    g.drawRect(0, 0, 400, 200);
}