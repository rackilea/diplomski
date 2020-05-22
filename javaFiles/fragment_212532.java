bt.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
       // TODO add your handling code here
       int[] ret = new int[SQL.freetables().size()];
       Iterator<Integer> iterator = SQL.freetables().iterator();
       for (int i = 0; i < ret.length; i++)
       {
          ret[i] = iterator.next().intValue();
          int num=SQL.freetables().size() + 1;
          this.btn = new JButton();
          this.btn.setText("" + ret[i]);
          this.btn.setSize(60,20);
          int x = 100+(80*i);
          this.btn.setLocation(x, 140);
          this.btn.setVisible(true);
          this.add(btn);   
          btn.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent ae) { 
               // TODO add your handling code here:
               System.out.print("\b Test: " + btn.getText());
             } 
          }

          this.revalidate();
          this.repaint();
       }
    }
});