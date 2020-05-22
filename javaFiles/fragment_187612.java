public GlassView() {
     DrawPanel panel = new DrawPanel();
     panel.setPreferredSize(new Dimension(WIDTH,HEIGHT)); //you need it for "pack()"
     this.add(panel);
     //this.setSize(WIDTH, HEIGHT);
     this.pack();
     int h=this.getHeight();
     int w=this.getWidth();
     System.out.println(h);
     System.out.println(w);
     this.setVisible(true);
 }