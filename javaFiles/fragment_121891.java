import java.io.*;
   class array {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();
        int length = tmp.length();
        char c[] = new char[length];
        tmp.getChars(0, length, c, 0);
        CharArrayReader input1 = new CharArrayReader(c);
        int i;
        System.out.print("input1 is:");
        while ((i = input1.read()) != -1) {
            System.out.print((char) i);
        }

    }
}