public class App {
    private final InputStream input;
    private final OutputStream output;

    public App(InputStream input, OutputStream output) {
        this.input = input;
        this.output = output;
    }

    public static void main(String[] args) {
        new App(System.in, System.out).start();
    }

    public void start() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(input));
            output.print("Enter something : ");
            String nextInput = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}