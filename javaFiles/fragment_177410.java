List<Process> processes = new ArrayList<Process>();
// noticed I turned your while loop into a for loop
for (i = 0; i < 10 i++) {
    int arg1 = i + 1;
    Process p = rt.exec("abc.exe "+ arg1);
    processes.add(p);
}
...
// watch them to see if any of them has finished
// this can be done periodically in a thread
for (Process process : processes) {
   try {
       if (process.exitValue() != 0) {
           // it did not exit with a 0 so restart it
           ...
       }
   } catch (IllegalThreadStateException e) {
       // still running so we can ignore the exception
   }
}