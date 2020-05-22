private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {
    // TODO add your handling code here:

            Random randomGenerator = new Random();
            for (int idx = 1; idx <= 10; ++idx) {
                q = randomGenerator.nextInt(100);
            }
            jpl1.removeAll();
            jpl1.printMe(ClassA.q); // HERE - REMOVED new and using jpl1 instance
            jpl1.setBackground(Color.BLUE);
            jpl1.revalidate();
            jpl1.repaint();
}