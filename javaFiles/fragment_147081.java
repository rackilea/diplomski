public class JavaApplication10 {
    static HashMap<String, Boolean> map = new HashMap<>(); 


    public static void main(String[] args){

        byte[] dataInByte = map.toString().getBytes();
        String sender ="";
        for (byte b : dataInByte) {
            sender = sender + (Integer.toBinaryString(b));
        }
        System.out.println(sender);   
    }
}