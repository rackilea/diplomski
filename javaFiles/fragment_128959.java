public class TestCmd {

    public static void main(String[] args) throws IOException
    {
        System.out.println("Started. args[0]=" + args[0]);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for(;;)
        {
            String line = in.readLine();
            if (line == null) break;
            System.out.println("echo:" + line);
        }
    }
}