public JFrameClassen(){
   super("Window with pictures");

   p = new JPanel();
   p.setBackground(Color.GREEN);

   // This will stack your newly created panels.
   p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));

   // This will generate a scroll bar. You may need it 
   JScrollPane pane = new JScrollPane(p);

   add(pane);

   setBounds(1300, 500, 400, 400);
   setVisible(true);
   setDefaultCloseOperation(EXIT_ON_CLOSE);

 }