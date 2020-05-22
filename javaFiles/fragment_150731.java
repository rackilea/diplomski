final Process proc = new ProcessBuilder(
            "/bin/bash", "-c",
            "for i in `seq 1 10`; do echo $i; sleep $((i % 2)); done")
           .start();
try(InputStreamReader isr = new InputStreamReader(proc.getInputStream())) {
    int c;
    while((c = isr.read()) >= 0) {
        System.out.print((char) c);
        System.out.flush();
    }
}