public static void main(String[] args) {
    for(int i=0; i<getSize(); i++) {
        System.out.println("i: " + i);
    }
}

private static int getSize() {
    int size = new Random().nextInt(10);
    System.out.println("size: " + size);
    return size;
}