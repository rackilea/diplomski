JPanel rightPanel = new JPanel(); // use your GridBagLayout.
frame.add(rightPanel, BorderLayout.CENTER);

JPanel leftPanel = new JPanel(); // use you current layout
JPanel wrapper = new JPanel(new BorderLayout()); 
wrapper.add(leftPanel, BorderLayout.PAGE_START);
frame.add(wrapper, Border.LINE_START);