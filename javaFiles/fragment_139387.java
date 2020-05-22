JSplitPane split_pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
        message_pane, table_pane);
  System.out.println("split_pane.getAlignmentX() before:"
        + split_pane.getAlignmentX());
  split_pane.setAlignmentX(LEFT_ALIGNMENT); // NOT REALLY NEEDED
  System.out.println("split_pane.getAlignmentX() after:"
        + split_pane.getAlignmentX());

  mQueryField = new JTextField();
  mQueryField.setMaximumSize(new Dimension(Short.MAX_VALUE, 20));
  System.out.println("mQueryField.getAlignmentX() before: "
        + mQueryField.getAlignmentX());
  mQueryField.setAlignmentX(LEFT_ALIGNMENT);
  System.out.println("mQueryField.getAlignmentX() after: "
        + mQueryField.getAlignmentX());