ProcessBuilder pb = new ProcessBuilder(
    convert, "-region", f.w+"x"+f.h+"+"+x+"+"+y, "-blur 0.0x10.0", path);
pb.redirectError();
Process process = pb.start();
BufferedReader in = new BufferedReader(
    new InputStreamReader(process.getInputStream()));