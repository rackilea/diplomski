b1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
             jl.setText(s.toUpperCase());
      }
  });

    b2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            jl.setText(s.toLowerCase());    
      }
  });

    b3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            s = JOptionPane.showInputDialog(frame, "");   
            jl.setText(s);
      }
  });

    b4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
             jl.setText("Hello World");
      }
  });