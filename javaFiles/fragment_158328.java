for(int i = 1; i < list.size(); i++)
{
   String[] line  = list.get(i).split(" ");

   System.out.println("The name of this post office is " + line[0]);
}