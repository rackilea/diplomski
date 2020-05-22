MyTextArea myTextArea = new MyTextArea();
JScrollPane myScrollPane = new JScrollPane(myTextArea, 
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
systemLook();
setTitle("Text editor");
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
setSize(new Dimension(800, 700));
setVisible(true);
setJMenuBar(new MyMenuBar(myTextArea));