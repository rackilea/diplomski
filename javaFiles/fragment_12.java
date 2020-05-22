JPanel helper = new JPanel(
            new MigLayout(
                    "", 
                    "5[grow,fill]10[grow,fill,20:100]10[grow,fill,20:100]5",
                    "5[fill,grow]5"));
    helper.add( new JLabel( "Threshold:" ), "cell 0 0" );
    threshold = new JTextField();                  // Assuming this was declared earlier
    Icon thresholdIcon = UIManager.getIcon( "OptionPane.questionIcon" );
    JLabel thresholdIconLabel = new JLabel( thresholdIcon );
    thresholdIconLabel.setToolTipText( "Threshold for template matching" );
    helper.add( threshold, "cell 1 0" );
    helper.add( thresholdIconLabel, "cell 2 0" );