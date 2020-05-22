MyPanel obj;
   fram(){
      JPanel panel = new JPanel();
      add(panel);
      JButton btn1 = new JButton("Draw Circle");
      JButton btn2 = new JButton("Draw Lines");
      btn1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
           obj.circZ =...;
        }
      });
      btn2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
           obj.circZ =...;
        }
      });
      panel.add(btn1);
      panel.add(btn2);
      obj = new MyPanel();
      panel.add(obj);
  }