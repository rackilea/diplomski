JScrollPane tree_jsp = new JScrollPane( jt );

    JPanel left_panel = new JPanel();
    left_panel.setLayout( new BorderLayout() );
    left_panel.add( tree_jsp, BorderLayout.WEST );

    JSplitPane split_pane = new JSplitPane();
    split_pane.setDividerLocation( 0.5d );
    // split_pane.setLeftComponent( tree_jsp );
    split_pane.setLeftComponent( left_panel );