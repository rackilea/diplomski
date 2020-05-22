class ChangeTitle {

    private static native void setTitle(String s);

    static {
        System.loadLibrary("ChangeTitle");
    }

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 5; i++) {
            String title = "Hello! " + i;
            System.out.println("Setting title to: " + title);
            setTitle(title);
            Thread.sleep(1000);
        }
    }
}