private final static String[] comLines = {
                        "ls /var/spool/postfix",
                        "perl count50.pl",
                        "cat MultiExec.java",
                        "head -40 /etc/apache2/apache2.conf"};

        public void execute() {
                for (int i = 0 ; i < comLines.length ; i++) {
                        ExecutableChild ec = new ExecutableChild (i, comLines[i]);
                        new Thread (ec).start();
        }}

        public class ExecutableChild implements Runnable {

                private int prIndex;
                private String executable;

                public ExecutableChild (int k, String cmd) {
                        prIndex = k;
                        executable = cmd;
                }

                public void run () {
                        try {
                                Process child = Runtime.getRuntime().exec(executable);
                                BufferedReader br = new BufferedReader (new InputStreamReader (
                                                                child.getInputStream()));
                                for (String s = br.readLine() ; s != null ; s = br.readLine()) {
                                        System.out.println ("[" + prIndex + "] " + s);
                                        try {
                                                Thread.sleep (20);
                                        } catch (InterruptedException intex) {
                                }}
                                br.close();
                        } catch (IOException ioex) {
                                System.err.println ("IOException for process #"+
                                                                prIndex+ ": " + ioex.getMessage());
        }}}

        public static void main (String[] args) {
                new MultiExec().execute();
}}