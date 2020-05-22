public class TestMain {
    public static void main(String a[]) throws InterruptedException {

        List<String> commands = new ArrayList<String>();
        commands.add("telnet");
        commands.add("www.google.com");
        commands.add("80");
        ProcessBuilder pb = new ProcessBuilder(commands);
        pb.redirectErrorStream(true);
        try {

            Process prs = pb.start();
            Thread inThread = new Thread(new In(prs.getInputStream()));
            inThread.start();
            Thread.sleep(2000);
            OutputStream writeTo = prs.getOutputStream();
            writeTo.write("oops\n".getBytes());
            writeTo.flush();
            writeTo.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class In implements Runnable {
    private InputStream is;

    public In(InputStream is) {
        this.is = is;
    }

    @Override
    public void run() {
        byte[] b = new byte[1024];
        int size = 0;
        try {
            while ((size = is.read(b)) != -1) {
                System.err.println(new String(b));
            }
            is.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}