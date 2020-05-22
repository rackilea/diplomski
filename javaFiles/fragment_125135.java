public void print(String msg, int count) {
    msg = (msg != null)? msg : "Default";
    while(--count >= 0) {
        System.out.println(msg);
    }
}