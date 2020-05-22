run.dispose();
        GUI ran = new GUI();
        ran.setPreferredSize(new Dimension(800, 500));
        ran.setResizable(false);
        ran.setVisible(true);
        ran.setLocation(250,150);
        ran.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        ImageIcon img = new ImageIcon("C:/Users/hp/documents/MyLogo.png");
        ran.setIconImage(img.getImage());
        ran.setTitle( "Pearl Math-Whiz");
        ran.pack();



    }