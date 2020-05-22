public interface CLibrary1 extends Library
{
    public Pointer string_test(String str1, String str2); 
}

public static void main(String[] args)
{
    try {
        CLibrary1 clib1 = (CLibrary1)Native.loadLibrary("???.so", CLibrary1.class);
        Pointer p = clib1.string_test("string1", "string3");
        System.out.println(p.getString(0));
        Native.free(Pointer.nativeValue(p));
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}