public static void main(String[] args) throws Exception
{
    System.out.println("i am client");
    System.out.println("");

    Socket soc = new Socket("localhost", 12345);
    System.out.println("Server is connected");

    DataInputStream dis = new DataInputStream(soc.getInputStream());

    int filecount = dis.readInt();
    File[] files = new File[filecount];
    System.out.println("filecount : " + filecount);

    byte[] b = new byte[1024];

    for (int i = 0; i < filecount; i++)
    {
        long filelength = dis.readLong();
        String filename = dis.readUTF();
        System.out.println("filename : " + filename);

        files[i] = new File(dirPath + "/" + filename);

        FileOutputStream fos = new FileOutputStream(files[i]);

        int loops = (int) (filelength / (long) b.length);
        int remainder = (int) (filelength % (long) b.length);

        for (int j = 0; j < loops; j++)
        {
            dis.readFully(b);
            fos.write(b);
        }

        if (remainder > 0)
        {
            dis.readFully(b, 0, remainder);
            fos.write(b, 0, remainder);
        }
    }

    System.out.println("data received!");

    dis.close();

    System.out.println("client closed!");
}