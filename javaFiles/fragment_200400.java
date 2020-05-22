JMapFrame frame;
    MapContent map;
    frame = new JMapFrame(map);
    frame.enableLayerTable(true);
    frame.setSize(800, 600);
    frame.enableStatusBar(true);        
    frame.enableToolBar(true);                
    JMenuBar menuBar = new JMenuBar();                          
    frame.setJMenuBar(menuBar);