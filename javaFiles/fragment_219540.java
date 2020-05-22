import java.io.File;
class Test {
    public static void main(String[] args) {
        File dir = new File(".");
        if(!dir.isDirectory()) throw new IllegalStateException("wtf mate?");
        for(File file : dir.listFiles(new RegexFileFilter("@*\\.ser"))) {
                process(file);
        }
    }

    public static void process(File f) {
        System.out.println(f.getAbsolutePath());
    }
}