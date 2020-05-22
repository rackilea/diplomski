public class Test1 {

    public static void main(String[] args) {
        new Test1();  
    }
    Test1(){
        BufferedInputStream file= (BufferedInputStream) this.getClass().getResourceAsStream("resources/a.txt");
        try {
            System.out.println((char)file.read());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}