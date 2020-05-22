public void GenerateNumber() {
    Random rnd1 = new Random();
    try {
        lbl1.setText(String.valueOf(rnd1.nextInt(100)));
    } catch (InterruptedException inrptdEx) {
    }
    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            dispose();
        }
    });
    timer.setRepeats(false);
    timer.start();
}