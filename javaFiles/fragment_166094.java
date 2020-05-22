int testcases = Integer.parseInt(temp);
int i=0;
List<Integer> list = new ArrayList<Integer>();
while(i<=testcases)
{
   System.out.println("Enter the W and H");
   String array = br.readLine(); //this takes only input in single line
   String No[] = array.trim().split("\\s+");
   //int intarray[]= new int[testcases];

   for(int i =0;i<No.length;i++)
   {
     //intarray[i]=Integer.parseInt(No[i]);
     list.add(Integer.parseInt(No[i]));
   }
   Integer[] intArray = list.toArray(new Integer[0]);
   System.out.println(Arrays.toString(intarray));  
   i++;
}