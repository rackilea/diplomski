public class JSSTest {

    public static void main(String args[]){
        JSSTest test = new JSSTest();
        // Just to show it's not part of creation...
        System.out.println("After object creation");
        test.toString();
    }

    @Override
    public boolean equals(Object obj){
        System.out.println("equals");
        return false;
    }

    @Override
    public int hashCode(){
        System.out.println("hashCode");
        return super.hashCode();
    }
}