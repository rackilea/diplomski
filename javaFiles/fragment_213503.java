package in.ksharma;

import com.sun.jna.Native;

public class Test {
    public static void main(String[] args) {
        VmCheck lib = (VmCheck) Native.loadLibrary("VmDetect.dll", VmCheck.class);
        if(lib.IsInsideVMWare() || lib.IsInsideVPC())
            System.out.println("I'm trapped in the matrix.");
        else 
            System.out.println("I'm for real.");
    }
}