public class SeamCarving {
    static String pathFrom = "C:/Users/lenovo/Desktop/h4/01.jpg";
    static String pathTo = "d:/02.jpg";

    public static void main(String[] args) throws Exception {
        File file1 = new File(pathFrom);
        File file2 = new File(pathTo);

        FileInputStream fis = new FileInputStream(pathFrom);
        FileOutputStream fos = new FileOutputStream(pathTo);

        System.out.println(file1.length());
        int buffSize;
        byte[] buffer = new byte[1024];
        while ((buffSize = fis.read(buffer)) > 0) {
            fos.write(buffer, 0, buffSize);
        }
        System.out.println(file2.length());

        fis.close();
        fos.close();
    }
}