public class newq {

    public static void main(String[] args)
    {
        ArrayList<String> dictionary=new ArrayList<String>();
        dictionary.add("hello");
        dictionary.add("hello");
        dictionary.add("asd");
        dictionary.add("qwet");
        dictionary.add("qwet");
        HashMap<String,Integer> hs=new HashMap<String,Integer>();
        int i=0;
        while(i<dictionary.size())
        {
            String word=dictionary.get(i);
            if(hs.containsKey(word))   // check if word repeated
            {
               hs.put(word, hs.get(word)+1); //if repeated increase the count
               dictionary.remove(i); // remove the word

            }
            else
            {
               hs.put(word, 1);  //not repeated
               i++;
            }

       }
       Iterator it = hs.entrySet().iterator();
       while(it.hasNext())
        {
          HashMap.Entry pair = (HashMap.Entry)it.next();
           System.out.println(pair.getKey() + " = " + pair.getValue());
          it.remove();
        }
        for(String word: dictionary)
        {
           System.out.println(word);
        }
   }
}