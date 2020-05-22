Scanner input = new Scanner(new File("file.txt"));
while(input.hasNextLine())
{
   String word = input.nextLine();
   if(word.length()>10){
      System.out.println(word)
     }
}