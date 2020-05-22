Process proc = new ProcessBuilder().command(commandArgs).start();
long startMillis = System.currentTimeMillis();
synchronized (proc) {
    proc.wait(someTimeoutMillis);
}
long diff = System.currentTimeMillis() - startMillis;
// if we get here without being interrupted and the delay time is more than
// someTimeoutMillis, then the process should still be running
if (diff >= someTimeoutMillis) {
   proc.destroy();
}