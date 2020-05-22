//Where dataPanel is a JPanel I want to be able to scroll
  JScrollPane roller = new JScrollPane (dataPanel, 
                           JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                           JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

  JPanel scrollerPanel = new JPanel();
  JScrollBar scrollBar = roller.getVerticalScrollBar();
  scrollBar.setPreferredSize(new Dimension (20, 100));

  scrollPanel.add(scrollBar);