public class Example {

    public static void main(String args[])
    {
        String[] byte1 = {"2","45","56","1"};
        for (int i = 0; i < byte1.length; i++) {
            if(byte1[i].length()<2){
                byte1[i] = "0"+byte1[i];
            }
        }
        char[][] chr = new char[5][10];
        StringBuilder buffer = new StringBuilder();
        for(int i = 0; i < byte1.length;i++){
               chr[i] = byte1[i].toCharArray();
        }


    for (int i = 0; i < chr.length; i++) {
            System.out.println(chr[i]);
    }
    }
}