private  void draw(Graphics g){
    if(status.equals("Empty")){//paints x if empty
       if(turn%2 != 0){//if turn is odd the color is green
        g.setColor(Color.green);
       }
       else//if even the color is yellow
           g.setColor(Color.yellow);

       g.drawLine(0, 0, getWidth(), getHeight());
       g.drawLine(getHeight(), 0, getWidth(), 0);
       // This is bad idea...
       setStatus("X");
   } 
}