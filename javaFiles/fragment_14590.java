public static void main(String[] args)
{
    HashMap<Character, Integer> store = new HashMap<Character, Integer>();
    arrangeFrequency("ababaABABR", store);
    arrangeFrequency("ababp", store);

    Object[] output =store.keySet().toArray(); 
    Arrays.sort(output);
    System.out.println(Arrays.toString(output));
}

private static void arrangeFrequency(String str, HashMap<Character, Integer> s1)
{
    int defaultVal = (s1.isEmpty()) ? 1: -1;
    for(int i=0; i<str.length();i++)
    {
        char c = str.charAt(i);
        if(Character.isLetter(c))
        {
            int val = s1.containsKey(c) ? (s1.get(c).intValue()+defaultVal) : 1;
            if(val>0)
                s1.put(c, val);
            else
                s1.remove(c);
        }
   }
}