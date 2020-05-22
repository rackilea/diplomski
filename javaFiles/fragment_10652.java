HelloWorldFrame()
 {
    JLabel jlb=new JLabel("HelloWorld");  
    jlb.setHorizontalAlignment(50); // set the horizontal alignement on the x axis !
    jlb.setVerticalAlignment(50); // set the verticalalignement on the y axis !
    add(jlb);
    this.setSize(100,100);
    setVisible(true);
 }