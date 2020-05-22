counthrd(String s, counthrd cnt1) {
    thrd = new Thread(this, s);
    this.cnt1 = cnt1;
    thrd.start();
    x = s;
}