JPanel top = new JPanel( new GridLayout(0, 3) );
top.add( new JLabel("Label1") );
top.add( new JLabel("Label2") );
top.add( new JLabel("Label3") );

JTextArea textArea = new JTextArea(5, 30);

JPanel bottom = new JPanel( new GridLayout(0, 2) );
bottom.add( new JButton("Button1") );
bottom.add( new JButton("Button2") );

JPanel tab1 = new JPanel( new BorderLayout() );
tab1.add(top, BorderLayout.PAGE_START);
tab1.add(new JScrollPane(textArea), BorderLayout.CENTER);
tab1.add(bottom, BorderLayout.PAGE_END);

JTabbedPane tabbedPane = new JTabbedPane();
tabbedPane.addTab("Tab1", tab1);

frame.add(tabbedPane);