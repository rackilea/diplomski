package javaapplication2;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Chirag
 */
public class NativeTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Loading library NativeCube");
        try {
            NativeCube n = new NativeCube();
            System.out.println("Loading Library NativeCube succeeded");
            System.out.print("Enter a number to get cube: ");
            int x = sc.nextInt();
            System.out.println(x + " * " + x + " * " + x + " = " + n.cubecal(x));
        } catch (Throwable e) {
            System.err.println("Error loading library nativeLib: " + e);
            e.printStackTrace();
        }
    }

}

class NativeCube {

    public NativeCube() {
        System.setProperty("java.library.path", new File("").getAbsolutePath());
        System.out.println("Pathes: " + System.getProperty("java.library.path"));
        String arch = System.getProperty("sun.cpu.isalist");
        if (arch.trim().equalsIgnoreCase("amd64")) {
            System.loadLibrary("NativeCube");
        } else {
            System.loadLibrary("NativeCube_x86");
        }
    }

    public native int cubecal(int x);

}