JPanel scrollContentPane = new JPanel();
// to set the size properly see later
JPanel scrollContentPaneViewport = new JPanel(new FlowLayout());
scrollContentPaneViewport.add(scrollContentPane);
JScrollPane scrollPane = new JScrollPane();
scrollPane.getViewport().setView(scrollContentPaneViewport);