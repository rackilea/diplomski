public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == b1) {
        r1ready = true;
    } else if (ae.getSource() == r1) {
        if (r1ready) {
          // do something
        }
    }
}