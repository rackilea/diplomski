contentPane = new JPanel();
setContentPane(contentPane);
CustomCanvas panel = new CustomCanvas();
panel.setBounds(0, 0, this.getWidth(), this.getHeight());
int xx, yy;
contentPane.add(panel);
contentPane.setLayout(null);

JToolBar toolBar = new JToolBar("This is the toolbar");
toolBar.setBounds(0, 0, 800, 50);
toolBar.setVisible(true);