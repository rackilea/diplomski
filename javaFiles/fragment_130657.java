@Override
public void run() {
    try {
        Goo window = new Goo();
        window.frame.setVisible(true);
    } catch (Exception e) {
        e.printStackTrace();
    }
}