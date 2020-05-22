// import java.io.*;
// import java.net.URLDecoder;
// throws java.io.UnsupportedEncodingException 

    String path = UpdaterCore.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    String decodedPath = URLDecoder.decode(path, "UTF-8");
    System.out.println(decodedPath);