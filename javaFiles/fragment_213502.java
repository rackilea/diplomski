package in.ksharma;

import com.sun.jna.Library;

public interface VmCheck extends Library {
    boolean IsInsideVMWare();
    boolean IsInsideVPC();
}