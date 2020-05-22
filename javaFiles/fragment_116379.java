private void jButton1ActionPerformed(ActionEvent evt) {                                         
    final Timer t = new Timer(50, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            jProgressBar1.setValue(jProgressBar1.getValue() + 1);
            if (jProgressBar1.getValue() == 100) {
              ((Timer) e.getSource()).stop();
            }
        }
    });
    t.start();
}