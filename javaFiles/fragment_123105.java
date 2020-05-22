private int a = 1;

public void setA(int a) {
    this.a = a;
    update();
}

public static void main(String[] args) {
    Main m = new Main();
    m.setA(2);
}