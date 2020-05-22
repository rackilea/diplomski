public class test{
    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().exec("CMD /c COPY /b \"D:\\1\\1.bin\" + \"D:\\1\\2.bin\" \"D:\\1\\3.bin\"");

    }
}