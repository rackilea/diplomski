b2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
           //!! ButtonFrame bf = new ButtonFrame();
           if ("calculate".equals(e.getActionCommand())) {

              //!! note use of ButtonFrame.this:
              JOptionPane.showMessageDialog(frame, ButtonFrame.this.loanAmt.getText());
           }
        }

     });