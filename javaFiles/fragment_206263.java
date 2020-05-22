public CreatorUI(){

    componentMover.setAutoLayout(true);

    backgroundPane = new BackgroundUI().initComponents();
    moveablePane.setLayout(null);
    moveablePane.setOpaque(false);
    moveablePane.setSize(Toolkit.getDefaultToolkit().getScreenSize());

    layers.setLayout(new BorderLayout());


    layers.setLayer(moveablePane, JLayeredPane.DRAG_LAYER);
    layers.add(moveablePane, BorderLayout.CENTER);

    layers.setLayer(backgroundPane, JLayeredPane.DEFAULT_LAYER);
    layers.add(backgroundPane, BorderLayout.CENTER);


    add(layers, BorderLayout.CENTER);
    layers.setPreferredSize(backgroundPane.getPreferredSize());

    pack();
}