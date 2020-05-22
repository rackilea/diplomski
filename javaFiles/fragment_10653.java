HelloWorldFrame()
     {
        JLabel jlb=new JLabel("HelloWorld");  
        jlb.setHorizontalAlignment(SwingConstants.CENTER); // set the horizontal alignement on the x axis !
        jlb.setVerticalAlignment(SwingConstants.CENTER); // set the verticalalignement on the y axis !
        add(jlb);
        this.setSize(100,100);
        setVisible(true);
     }