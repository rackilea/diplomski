import java.io.*;

    //...
    for (File root : File.listRoots()) {
        System.out.println(root.getAbsolutePath());
        System.out.println(root.getTotalSpace());
    }