public static void main(String[] args) {
    Dog d = new Dog();
    for (int i = 0; i < 12; i++) {
        System.out.println(d);
        d.feed();
    }
}