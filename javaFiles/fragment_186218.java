public class Test {

    public static void main(String[] args) throws NoSuchFieldException, SecurityException {
        Path path = Paths.get("/my/test/folder/", "text.txt");
        String str = path.toString();
        // String str = String.valueOf(path); //This is Null Safe
        System.out.println(str);
    }

}