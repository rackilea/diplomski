public class WordCount      
{
    public static void main (String[] args)
    {
      String text ="";
      int wordLenght = 0;
      text = "Java is awesome for Me";
      System.out.println (text);


            String [] input = text.split(" ");
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < input.length; i++)
                {  
                    list.add(input[i].length());

                } 
            Set<Integer> unique = new HashSet<Integer>(list);

           for (Integer length : unique) {
               System.out.println("There are " + Collections.frequency(list, length) + " words of length " + length);
}
    } 
}