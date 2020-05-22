The Server side code example:


public class ServerTest {

    ServerSocket s;

    public void go() {

        try {
            s = new ServerSocket(44457);

            while (true) {

                Socket incoming = s.accept();
                Thread t = new Thread(new MyCon(incoming));
                t.start();
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    class MyCon implements Runnable {

        Socket incoming;

        public MyCon(Socket incoming) {

            this.incoming = incoming;
        }

        @Override
        public void run() {

            try {
                PrintWriter pw = new PrintWriter(incoming.getOutputStream(),
                        true);
                InputStreamReader isr = new InputStreamReader(
                        incoming.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                String inp = null;

                boolean isDone = true;

                System.out.println("TYPE : BYE");
                System.out.println();
                while (isDone && ((inp = br.readLine()) != null)) {

                    System.out.println(inp);
                    if (inp.trim().equals("BYE")) {
                        System.out
                                .println("THANKS FOR CONNECTING...Bye for now");
                        isDone = false;
                        s.close();
                    }

                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                try {
                    s.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {

        new ServerTest().go();

    }