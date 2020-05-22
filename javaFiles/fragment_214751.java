ProcessBuilder pb = new ProcessBuilder(
    "cmd", "/c", "start", "/b", "/wait", batchFile)
pb.redirectErrorStream(true);
Process p = pb.start();
IOUtils.closeQuietly(p.getOuputStream());
IOUtils.copy(p.getInputStream(), System.out);
// or alternatively throw away the output using
// IOUtils.copy(p.getInputStream(), NullOutputStream.NULL_OUTPUT_STREAM);
IOUtils.closeQuietly(p.getInputStream());
int returnVal = p.waitFor();