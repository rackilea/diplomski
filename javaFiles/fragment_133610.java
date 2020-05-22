JPanel nestingJPanel = new JPanel();
  nestingJPanel.add(new WideComponent());
  nestingJPanel.setBorder(createBorder());

  panel.add(wc);
  panel.add(button);
  panel.add(nestingJPanel);