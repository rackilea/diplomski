JSplitPane split_pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
        message_pane, table_pane);
  JPanel splitHolder = new JPanel(new BorderLayout());
  splitHolder.add(split_pane);

  mQueryField = new JTextField();
  mQueryField.setMaximumSize(new Dimension(Short.MAX_VALUE, 20));

  setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  add(splitHolder);
  add(mQueryField);