[0] active
[1] 1
[2] import java.io.*;
[3] #
[2]
[0] bounce
[1] 2
[3] # Based upon the NCSA server configuration files originally by Rob McCool.
[2] public class MultiExec {
[1] 3
[0] corrupt
[3] #
[1] 4
[2]
[0] defer
[3] # This is the main Apache server configuration file.  It contains the
[2]     private final static String[] comLines = {
[0] deferred
[1] 5
[3] # configuration directives that give the server its instructions.
[2]                     "ls /var/spool/postfix",
[0] etc
[1] 6
[3] # See http://httpd.apache.org/docs/2.2/ for detailed information about
[2]                     "perl count50.pl",
[0] flush
[1] 7
[3] # the directives.
[2]                     "cat MultiExec.java",
[1] 8
[0] hold
[3] #
[1] 9
[2]                     "head -40 /etc/apache2/apache2.conf"};
[0] incoming
[3] # Do NOT simply read the instructions in here without understanding
[2]
[0] lib
[1] 10
[3] # what they do.  They're here only as hints or reminders.  If you are unsure
[1] 11
[2]     public void execute() {
[0] maildrop
[3] # consult the online docs. You have been warned.
[2]             for (int i = 0 ; i < comLines.length ; i++) {
[0] pid
[1] 12
[3] #
[1] 13
[2]                     ExecutableChild ec = new ExecutableChild (i, comLines[i]);
[0] private
[3] # The configuration directives are grouped into three basic sections:
[1] 14
[2]                     new Thread (ec).start();
[0] public
[3] #  1. Directives that control the operation of the Apache server process as a
[2]     }}
[1] 15
[0] saved
[3] #     whole (the 'global environment').
[1] 16
[0] trace
[2]
[3] #  2. Directives that define the parameters of the 'main' or 'default' server,
[0] usr
[2]     public class ExecutableChild implements Runnable {
[1] 17
[3] #     which responds to requests that aren't handled by a virtual host.
[0] var
[2]
[1] 18
[3] #     These directives also provide default values for the settings
[1] 19
[2]             private int prIndex;
[3] #     of all virtual hosts.
[1] 20
[2]             private String executable;
[3] #  3. Settings for virtual hosts, which allow Web requests to be sent to
[2]
[1] 21
[3] #     different IP addresses or hostnames and have them handled by the
[1] 22
[2]             public ExecutableChild (int k, String cmd) {
[3] #     same Apache server process.
[1] 23
[2]                     prIndex = k;
[3] #
[1] 24
[2]                     executable = cmd;
[3] # Configuration and logfile names: If the filenames you specify for many
[2]             }
[1] 25
[3] # of the server's control files begin with "/" (or "drive:/" for Win32), the
[2]
[1] 26
[3] # server will use that explicit path.  If the filenames do *not* begin
[1] 27
[2]             public void run () {
[3] # with "/", the value of ServerRoot is prepended -- so "/var/log/apache2/foo.log"
[1] 28
[2]                     try {
[3] # with ServerRoot set to "" will be interpreted by the
[1] 29
[2]                             Process child = Runtime.getRuntime().exec(executable);
[3] # server as "//var/log/apache2/foo.log".
[1] 30
[2]                             BufferedReader br = new BufferedReader (new InputStreamReader (
[3] #
[1] 31
[2]                                                             child.getInputStream()));
[3]
[1] 32
[2]                             for (String s = br.readLine() ; s != null ; s = br.readLine()) {
[3] ### Section 1: Global Environment
[1] 33
[2]                                     System.out.println ("[" + prIndex + "] " + s);
[3] #
[1] 34
[2]                                     try {
[3] # The directives in this section affect the overall operation of Apache,
[1] 35
[2]                                             Thread.sleep (20);
[3] # such as the number of concurrent requests it can handle or where it

......