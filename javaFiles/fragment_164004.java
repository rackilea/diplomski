if (bgGroup.getSelection() == null) {
    // only handle `sem`
    SrchEMsg sem = new SrchEMsg(this);
    sem.setVisible(true);
    sem.setLocationRelativeTo(null);
    sem.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
} else {
    // only handle `sr`
    SrchResult sr = new SrchResult();
    sr.setVisible(true);
    sr.pack();
    sr.setLocationRelativeTo(null);
    sr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.dispose();
}