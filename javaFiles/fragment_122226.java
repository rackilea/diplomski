public void paint(Graphics g){

    super.paint(g);
    System.out.println("________________");
    Graphics2D g2d = (Graphics2D) g.create();
    Figure f = generate();
    int length = f.getX()[0].length;
    for(int j =0; j<f.getX().length; j++){
        System.out.println();

        for(int i=0; i<f.getX()[0].length; i++){                      

            if (f.getX()[j][i] == 1){
                Rectangle2D p = new Rectangle2D.Double(xs, ys, 10, 10);
                g2d.setColor(f.getY());
                g2d.draw(p);
                //g2d.drawRect(p.x, p.y, p.width, p.height);    
                //g2d.fillRect(p.x, p.y, p.width, p.height);                    
                //System.out.println("widnth: " +p.width + " | height: " + p.height + " end ");
                System.out.print("*");
            }
            else System.out.print(" ");
            xs+=10;
        }
        xs = 0;
        ys+=10;             
    }
    xs=0;
    ys=0;
    actiondelay();                      
   //g.setColor(Color.white);
   //g.drawRect(45, 95, 55, 105);        
}