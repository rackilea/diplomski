public static void main(String[] args) {
    ProcessBuilder pb = new ProcessBuilder(
        System.getenv("ProgramFiles") + "/7-Zip/7z.exe",
            "x",
            inputZIPFile,
            "-o" + outputFolder+"/SpecificFolder",
            "-r"
    );
    pb.redirectError();
    try {
        Process p = pb.start();
        new Thread(new InputConsumer(p.getInputStream())).start();
        System.out.println("Exited with: " + p.waitFor());
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

public static  class InputConsumer implements Runnable {
    private InputStream is;

    public InputConsumer(InputStream is) {
        this.is = is;
    }

    @Override
    public void run() {
        try {
            int value = -1;
            while ((value = is.read()) != -1) {
                System.out.print((char) value);
            }
        } catch (IOException exp) {
            exp.printStackTrace();
        }
        System.out.println("");
    }

}