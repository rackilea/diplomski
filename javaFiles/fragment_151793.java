@Override
protected void paintComponent(Graphics g){
    super.paintComponent(g);
    for (MyImage i : myList)
        i.draw(g);
}