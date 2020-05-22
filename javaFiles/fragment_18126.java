public static void main(String[] args)
{
    List<Player> results = new ArrayList<Player>();
    BufferedReader br;
    try 
    {
        br = new BufferedReader(new FileReader("myFile.txt"));
        String line = br.readLine();
        while(line != null)
        {
            String name = line;
            double score = Double.parseDouble(br.readLine());
            results.add(new Player(name, score));
            line = br.readLine();
        }
        br.close();
    } 
    catch (FileNotFoundException e) 
    {
        e.printStackTrace();
    } 
    catch (IOException e) 
    {
        e.printStackTrace();
    }

    // Sort using the java.util.Collections utility class
    // Sorting will modify your original list so make a copy
    // if you need to keep it as is.
    Collections.sort(results);
    // Top 10
    List<Player> top10 = results.subList(0, 10);
}