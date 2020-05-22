// Load Image
        Log.v("Loading header image");
        _iBG = new ImageIcon("img/hpcount_top_bg.png").getImage();

        // Set size
        setSize(1024, 152);
        setPreferredSize(new Dimension(1024, 152));

        // Set position
        setLocation(0, 0);

        // Set visible
        setVisible(true);

        // Set layout
        setLayout(null);

        // Add children
        add(new Exit()); // Exit extends java.awt.Button