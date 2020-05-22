public class SolitaireHack {

    final static long baseAddress = 0x10002AFA8L;
    final static int[] offsets = new int[]{0x50,0x14};

    static Kernel32 kernel32 = (Kernel32) Native.loadLibrary("kernel32",Kernel32.class);
    static User32 user32 = (User32) Native.loadLibrary("user32", User32.class);

    public static void main(String... args)
    {

    }
}