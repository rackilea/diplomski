public class Test
{
    public static void main(String args[]) throws IOException
    {
        FileInputStream inputStream = new FileInputStream("C:\\readme.txt");
        FileOutputStream outputStream = new FileOutputStream("D:\\readme1.txt");
        //OutputStream outStream = response.getOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer, 0, 4096)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        outputStream.close();
    }
}