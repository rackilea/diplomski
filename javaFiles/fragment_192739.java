class A {

    private static Date theDate = null;

    // unchanged
    public static String useMethodA() { ... }
    }

    // unchanged
    public static String againUseMethodA() {... }

    public static Date methodA() {
        if (theDate == null)
        {
            theDate = B.createDate();
        }
        return theDate;
    }
}