public static void main(String[] args) throws IOException
{
    ServerSocket s1 = new ServerSocket(40021);
    while (true)
    {
        ss = s1.accept();
        Thread t = new Thread()
        {
            public void run()
            {
                try
                {
                    String command, temp;
                    Scanner sc = new Scanner(ss.getInputStream());
                    while (sc.hasNextLine())
                    {
                        command = sc.nextLine();
                        temp = command + " this is what you said.";
                        PrintStream p = new PrintStream(ss.getOutputStream());
                        p.println(temp);
                    }
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}