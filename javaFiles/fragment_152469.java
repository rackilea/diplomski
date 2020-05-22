public class Try {
    public static void main(String[] args) {
        try {
            BufferedReader b = new BufferedReader(new  InputStreamReader(System.in));
            for(String s = null; (s = b.readLine()) != null;){
                System.out.println(s);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
       }
    }
}