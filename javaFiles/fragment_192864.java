JPanel mainPanel = new JPanel();
Box box = Box.createVerticalBox();
mainPanel.add( box );
for (FlowPanel flowPanel : content) {
    flowPanel.setBorder(BorderFactory.createEmptyBorder(0, flowPanel.getDepth() * 10, 0, 0));
    box.add(flowPanel);
}
removeAll();
add(mainPanel, BorderLayout.CENTER);
revalidate();