class MakeGUI {
   JFrame smallframe;
   JButton close = new JButton("CLOSE ME");


   MakeGUI() {
       frame f1 = new frame();
       smallframe = new JFrame(); //want to close this one
       JPanel jp = new JPanel(new FlowLayout());
       smallframe.setSize(300, 300);
       smallframe.setLocationRelativeTo(null);
       smallframe.setDefaultCloseOperation(smallframe.DISPOSE_ON_CLOSE);
       close.addActionListener(new action());
       jp.add(close);
       smallframe.add(jp);
       smallframe.setVisible(true);
   }

   class action implements ActionListener {
       public void actionPerformed(ActionEvent e) {
           if (e.getSource() == close) {
               // use this instead of dispose
               smallframe.dispatchEvent(new WindowEvent(smallframe, WindowEvent.WINDOW_CLOSING));
               System.out.println("gotcha");
           }
       }
   }
}