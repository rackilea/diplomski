public class Main {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream(new File("data")) ; 
        for(int i = 49; i <= 58; ++i)
            fos.write(i);
        fos.close();
    }
}