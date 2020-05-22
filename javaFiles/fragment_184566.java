public static void main(String[] args) {
    SuperClass a = new SuperClass() { // ... 1st
        public void call() {
            System.out.println("Method call");
        }
        public void call2() {
            System.out.println("New call2 Method in Anonymous Class");
        }
    };
    ...
}