public static void writeFile()
{
    //set up for the user input
    Reader r = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(r);
    String str = null;

    try {
            //prompt the user to input data
            System.out.println("Type or paste your data and hit Ctrl + z");
            PrintWriter writer = new PrintWriter("weather.txt", "UTF-8");
            while((str = br.readLine())!=null)
            {
            //save the line

            writer.println(str);
            }
            writer.close();

    } catch (IOException e) {
        e.printStackTrace();
    }
}