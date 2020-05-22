public JPanel1(JFrame1 f1) {
    this.f1 = f1;
}
...
public void actionPerformend(...) {
    f1.getPanel2().getButtonB().setText("A is pressed");
}