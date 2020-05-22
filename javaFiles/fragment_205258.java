class C {
    public static void main(String args[]) {
        try {
            A a = new A();
        } catch (NoClassDefFoundError e) {
            //log the error or take some action
        }

        System.out.println("All good here, lets continue");
    }
}