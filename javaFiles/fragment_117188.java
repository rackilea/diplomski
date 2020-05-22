public class Connection implements Runnable
{

    @Override
    public void run()
    {

        try
        {
            ServerSocket ss = new ServerSocket(7000);
            while (true)
            {
                System.out.println("Server is listening");
                final Socket s = ss.accept();
                System.out.println("Client Accepted");

                Thread t2 = new Thread(new Runnable()
                {
                    public void run()
                    {
                        try
                        {
                            DataInputStream dis = new DataInputStream(s.getInputStream());
                            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                            while (true)
                            {
                                String test = dis.readUTF();
                                dos.writeUTF(test);
                                System.out.println(test);
                                dos.flush();
                            }
                        }
                        catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                        finally
                        {
                            try
                            {
                                s.close();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                t2.start();
            }
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException
    {
        Connection c = new Connection();
        Thread  t1 = new Thread(c);
        t1.setDaemon(true);
        t1.start();
        Runnable    r = new Runnable()
        {
            public void run()
            {
                try (Socket s = new Socket("localhost", 7000))
                {
                    DataOutputStream    dos = new DataOutputStream(s.getOutputStream());
                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    for (int i = 0; i < 10; i++)
                    {
                        dos.writeUTF("Hello from "+Thread.currentThread().getName());
                        String  reply = dis.readUTF();
                        Thread.sleep(10*1000);
                    }
                }
                catch (IOException|InterruptedException exc)
                {
                    exc.printStackTrace();
                }
            }
        };
        Thread  t2 = new Thread(r);
        Thread  t3 = new Thread(r);
        t2.start();
        t3.start();
        t2.join();
        t3.join();
    }
}