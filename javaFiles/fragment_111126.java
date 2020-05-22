Rect rect = new Rect();
  rect.setBorder(BorderFactory.createTitledBorder("rect"));

  JPanel panel = new JPanel();
  panel.setPreferredSize(new Dimension(500, 500));
  panel.setVisible(true);

  panel.add(rect);

  // frame.getContentPane().add(rect); //Will draw if its in the frame
  frame.getContentPane().add(panel); // but not in the panel

  frame.pack();
  frame.setVisible(true);

  System.out.println(rect.getSize());