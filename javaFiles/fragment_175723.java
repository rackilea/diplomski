public class App {
    public static void main(String args[]) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter something : ");
            String input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}