class MyWindow extends JFrame {
   public MyWindow() { 
       JLabel label=new JLabel("Hello");
       JButton button=new JButton("Ok");

       setLayoutManager(new MyLayoutManager(label,button)); // PASS THEM
       add(label);
       add(button);
       pack();
       setVisible(true);
   }
}