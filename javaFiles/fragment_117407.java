class TryBlock {
    public static void main(String[] args) {
        a();
        b();
    }

    public static boolean a() {
        try {
            System.out.println("A");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean b() {
        try {
            System.out.println("B");
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}