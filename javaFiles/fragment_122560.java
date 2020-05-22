public static void main(String[] args) throws IOException, InterruptedException {
    ProcessBuilder pb = new ProcessBuilder("python", "path\\to\\script.py");
    Process pr = pb.start();

    try (BufferedWriter writerToProc = new BufferedWriter(
            new OutputStreamWriter(pr.getOutputStream()));
            BufferedReader readerOfProc = new BufferedReader(
                    new InputStreamReader(pr.getInputStream()));
            BufferedReader errorsOfProc = new BufferedReader(
                    new InputStreamReader(pr.getErrorStream()))) {

        writerToProc.write("WhoIs\n");
        writerToProc.write("ReadHexFile\n"); // is this the syntax?
        writerToProc.write("SendFile 'path\to\file.txt'\n");
        writerToProc.flush();

        StringBuilder procOutput = new StringBuilder();
        boolean gaveUp = false;
        long waitTime = 10 * 1_000; // 10 seconds
        long lastRead = System.currentTimeMillis();
        for(;;) {
             final long currTime = System.currentTimeMillis();
             final int available = readerOfProc.available();
             if(available > 0){
                 // TODO read the available bytes without blocking
                 byte[] bytes = new byte[available];
                 readerOfProc.read(bytes);
                 procOutput.append(new String(bytes));

                 // maybe check this input for an EOF code
                 // your python task should write EOF when it has finished
                 lastRead = currTime;
             } else if((currTime - lastRead) > waitTime){
                 gaveUp = true;
                 break;
             }
        }


        // readerOfProc.lines().forEach((l) -> System.out.println(l));
        // errorsOfProc.lines().forEach((l) -> System.out.println(l));
    }
}