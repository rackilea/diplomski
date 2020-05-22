static List<Process> doPipeJava8() throws IOException {
    Process pSource = new ProcessBuilder("cmd", "/S/D/c", "dir", "/s/b", ".")
                    .redirectInput(ProcessBuilder.Redirect.INHERIT)
                    .redirectError(ProcessBuilder.Redirect.INHERIT)
                    .start();
    Process pTarget;
    try {
        pTarget     = new ProcessBuilder("cmd", "/S/D/c", "findstr", "dat$")
                    .redirectErrorStream(true)
                    .redirectOutput(ProcessBuilder.Redirect.INHERIT)
                    .start();
    } catch(Throwable t) {
        pSource.destroyForcibly();
        throw t;
    }
    new Thread(() -> {
        try(InputStream srcOut = pSource.getInputStream();
            OutputStream dstIn = pTarget.getOutputStream()) {
            byte[] buffer = new byte[1024];
            while(pSource.isAlive() && pTarget.isAlive()) {
                int r = srcOut.read(buffer);
                if(r > 0) dstIn.write(buffer, 0, r);
            }
        } catch(IOException ex) {}
    }).start();
    return Arrays.asList(pSource, pTarget);
}