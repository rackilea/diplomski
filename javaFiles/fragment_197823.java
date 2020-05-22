public class MyServer {

    public static void main(String[] args) throws IOException {
        new MyServer().Show();
    }

    public void Show() throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        int count = 0;
        while (true) {
            Socket s = null;
            try {
                s = ss.accept();
                SocketThread socketThread = new SocketThread(s, count);
                socketThread.start();

            } catch (Exception e) {
                s.close();
                System.out.println(e);
            } finally {
                count++;
            }
        }
    }

    class SocketThread extends Thread {

        Socket csocket;
        String ip = null;
        String host = null;
        String os_name = null;
        String os_arch = null;
        String os_version = null;
        String pro_detail = null;
        String Mac_add = null;
        float disk_size = 0;
        float max_memory = 0;
        int count;

        public SocketThread(Socket csocket, int count) {
            this.csocket = csocket;
            this.count = count;
        }

        public void run() {
            try {
                DataInputStream dis = new DataInputStream(csocket.getInputStream());
                host = (String) dis.readUTF();
                ip = (String) dis.readUTF();
                os_name = (String) dis.readUTF();
                os_arch = (String) dis.readUTF();
                os_version = (String) dis.readUTF();
//                pro_detail = (String) dis.readUTF();
                Mac_add = (String) dis.readUTF();
                disk_size = (long) (dis.readLong() / (1000000000));
                max_memory = (long) (dis.readLong() / (1000000000));
                csocket.close();
                dis.close();
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ShowTable.INSTANCE.showdata(count, host, ip, os_name, os_arch, os_version, pro_detail, Mac_add, disk_size, max_memory);
                    }
                });
            } catch (Exception e) {
                System.out.println("Server Problem");
                System.out.println(e);
            }
        }
    }
}