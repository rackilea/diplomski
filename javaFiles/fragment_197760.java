LayerUI backgroundUI = new WallpaperLayerUI();
    jlayer = new JLayer<JPanel>(panel, backgroundUI);

    LayerUI controlsUI = new LayerUI();
    JPanel controlPanel = new JPanel();
    MigLayout layout = new MigLayout(
            "debug, insets 10, gap 10, wrap", // Layout Constraints
            "[fill,grow][fill,grow][fill,grow]", // Column constraints with default align
            "[fill,grow][fill,grow][fill,grow]");
    controlPanel.setLayout(layout);
    controlPanel.add(new JButton("here"));
    controlPanel.add(new JButton("here"));
    controlPanel.add(new JButton("here"));
    controlPanel.add(new JButton("here"));
    controlPanel.add(new JButton("here"));
    controlPanel.add(new JButton("here"));
    controlPanel.add(new JButton("here"));
    controlPanel.add(new JButton("here"));
    controlPanel.add(new JButton("here"));

    jlayer2 = new JLayer<JPanel>(controlPanel, controlsUI);

    panel.addMouseListener(this);
    panel.addMouseMotionListener(this);
    panel.addMouseWheelListener(this);

    finalPanel = new JLayeredPane();
    finalPanel.setPreferredSize(new Dimension(300, 310));
    //finalPanel.setLayout(null);
    jlayer.setBounds(0, 0, (808-40)/3, (608-40)/3);
    jlayer2.setBounds(0, 0, (808-80)/3, (608-80)/3);
    controlPanel.setBackground(new Color(0,0,0,0));
    finalPanel.add(jlayer, new Integer(0));
    finalPanel.add(jlayer2 ,new Integer(1));