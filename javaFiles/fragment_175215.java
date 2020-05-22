final String s = "method string";
Runnable runnable = new Runnable() {
    public void run() {
        String s = "anonymous inner class string";
        String outerS = getS();
        System.out.println(outerS);
        System.out.println(s);
        // how can I access the method string here without the need to rename any of the variables
    }

    public String getS() {
        return s;
    }
};