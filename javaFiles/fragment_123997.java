import java.io.*;

class Rspace {
    public static void main(String args[]) throws IOException {
        int arr[] = new int[3];
        if (arr.length < 2) {
            System.out.print("Parameters are missing");
            System.exit(0);
        }
        if (arr.length > 2) {
            System.out.print("No. of parameters are exceeded");
            System.exit(1);
        }
        File f = new File(args[0]);
        if (!f.exists()) {
            System.out.print("File does not exists");
            System.exit(2);
        }
        FileInputStream fis = new FileInputStream(args[0]);
        FileOutputStream fos = new FileOutputStream(args[1]);
        int ch;
        boolean lastSpace = false;
        while ((ch = fis.read()) != -1) // Reading character & returning ASCII
                                        // value;shifting to next character
        {
            if (!Character.isWhitespace(ch)) {
                fos.write(ch);
                lastSpace = false;

            } else if (!lastSpace) {
                fos.write(ch);
                lastSpace = true;
            }
        }
        fis.close();
        fos.close();
    }
}