public class extraCredit{
    public static void main(String args[])
throws FileNotFoundException{
    Map<String,Integer> letCounts = new HashMap<String,Integer>();
    Scanner sc = new Scanner(new File("decrypt.txt"));
    while(sc.hasNextLine()){
        String line = sc.nextLine();
        for(String s : line.split(""))
            if(letCounts.containsKey(s))
                letCounts.put(s,letCounts.get(s)+1);
            else
                letCounts.put(s,1);
    }

    int maxCount=0;
    for(Map.Entry<String, Integer> e : letCounts.entrySet())
    {
        maxCount=Math.max(maxCount, e.getValue());
    }

    for(Map.Entry<String, Integer> e : letCounts.entrySet())
    {
        if(e.getValue()==maxCount)
            System.out.println(e.getKey()+e.getValue());
    }
  }
}