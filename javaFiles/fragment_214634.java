canvas = new MyClassExtendingJPanel();
canvas.setPreferredSize(new Dimension(123,456));
frame.getContentPane().add(canvas);
...
// At the end:
frame.pack(); 
frame.setVisible(true);