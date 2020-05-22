canvas.setLayout(new BorderLayout());

JPanel bottomPanel = new JPanel(); // Panel where you can
// place those buttons (by default,
// FlowLayout has been set on it)
bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
canvas.add(bottomPanel, BorderLayout.SOUTH);
bottomPanel.add(btn1);
bottomPanel.add(btn2);