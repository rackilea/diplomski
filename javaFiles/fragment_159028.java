Process proc = new ProcessBuilder().command(commandArgs).start();
try {
   // this will be interrupted by another thread
   int errorCode = proc.waitFor();
} catch (InterruptedException e) {
   // always a good pattern to re-interrupt the thread
   Thread.currentThread().interrupt();
   // our timeout must have expired so we need to kill the process
   proc.destroy();
}
// maybe stop the timeout thread here