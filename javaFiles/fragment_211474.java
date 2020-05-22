public static void main(String args[]) throws Exception {
    HelloThread ht = new HelloThread();
    int b = ht.a(1);
    System.out.println("Hello");
}

int a(int x) {
    for (int i = 0; i < 1000000; i++) {
        x = x * 5;
    }
    return x;
}