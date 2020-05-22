public static void main(String[] args) throws Exception
{
    System.out.println("i am server");
    System.out.println("");

    ServerSocket server = new ServerSocket(12345);
    System.out.println("Server is listening...");

    Socket client = server.accept();
    System.out.println("Client is connected");

    DataOutputStream dos = new DataOutputStream(client.getOutputStream());

    String dir = "C:\\Users\\Nitesh Rathi\\Downloads\\vcruntime140";
    Files[] files = new File(dir).listFiles();

    System.out.println("Files Selected : " + files.length);
    dos.writeInt(files.length);

    byte[] b = new byte[4096];

    for (File file : files)
    {
        long filelength = file.length();
        dos.writeLong(filelength);

        String filename = file.getName();
        dos.writeUTF(filename);
        System.out.println(filename);

        FileInputStream fis = new FileInputStream(file);
        DataInputStream dis = DataInputStream(fis);

        int loops = (int) (filelength / (long) b.length);
        int remainder = (int) (filelength % (long) b.length);

        for (int j = 0; j < loops; j++) 
        {
            dis.readFully(b);
            dos.write(b);
        }

        if (remainder > 0)
        {
            dis.readFully(b, 0, remainder);
            dos.write(b, 0, remainder);
        }
    }

    System.out.println("");

    dos.close();
    server.close();

    System.out.println("Server Closed!");
}