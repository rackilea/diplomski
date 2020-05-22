void start() { // sample game
    MyDialog dialog7 = new MyDialog(null);
    MyDialog dialog6 = new MyDialog(dialog7);
    MyDialog dialog5 = new MyDialog(dialog6);
    MyDialog dialog4 = new MyDialog(dialog5);
    MyDialog dialog3 = new MyDialog(dialog4);
    MyDialog dialog2 = new MyDialog(dialog3);
    MyDialog dialog1 = new MyDialog(dialog2);

    dialog1.setVisible(true);
}