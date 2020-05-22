public class TestClass{    
    public static void main(String[] args) {
        try{
            throw new RuntimeException();
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());
            System.out.println(e.getStackTrace());
            System.out.println(e.getStackTrace());
        }


        System.out.println(new String[]{"a","b"});
        System.out.println(new String[]{"a","b"});
        System.out.println(new String[]{"a","b"});
    }
}