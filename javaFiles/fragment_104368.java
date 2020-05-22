public static void seekOffset()
{
    try {
        RandomAccessFile file = new RandomAccessFile("IndexFile.txt", "r");
        file.seek(693);
        System.out.println(file.readLine());
    }
    catch(IOException ioe)
        {

        }
}