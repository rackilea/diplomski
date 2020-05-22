public static void main(String[] args) {
    class LocalClass extends SuperClass {
        public void call() {
            System.out.println("Method call");
        }
        public void call2() {
            System.out.println("New call2 Method in Anonymous Class");
        }
    }
    SuperClass b = new LocalClass();
    ...
}