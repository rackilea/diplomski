ActionListener one = new ActionListener() {
     public void actionPerformed(ActionEvent e) {
        if (gr1.getCounter1() < 5) {
           gr1.setCounter1(gr1.getCounter1() + 1);
           for (int i = 0; i < arraybtn.length; i++) {
              if (arraybtn[i] == e.getSource()) {
                 test1.setIcon(play1Icons[i]);
              }
           }
        } else {
           pn5.setText("No more cards");
        }
     }
  };