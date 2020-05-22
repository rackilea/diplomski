fge@alustriel:~/tmp/t$ cat Rename.java 
import java.io.File;

public final class Rename
{
    private Rename()
    {
    }

    public static void main(final String... args)
    {
        final File f1 = new File("/home/fge/tmp/t/foo");
        final File f2 = new File("/home/fge/tmp/t/bar");
        final File f3 = new File("/tmp/foo");

        if (f1.renameTo(f2))
            f2.renameTo(f3);
    }
}

fge@alustriel:~/tmp/t$ javac Rename.java
fge@alustriel:~/tmp/t$ strace -ff -o TRACE java Rename
fge@alustriel:~/tmp/t$ grep -w rename TRACE.*
TRACE.17107:rename("/home/fge/tmp/t/foo", "/home/fge/tmp/t/bar") = 0
TRACE.17107:rename("/home/fge/tmp/t/bar", "/tmp/foo") = -1 EXDEV (Invalid cross-device link)