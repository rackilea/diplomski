public int romanToInt(String s) 
{
 HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
 //Map Character to Integer
 dict.put('I', 1); //Used single quote to represent character
 dict.put('V', 5);
 dict.put('X', 10);
 dict.put('L', 50);
 dict.put('C', 100);
 dict.put('D', 500);
 dict.put('M', 100);
 int sum = 0;
 char[] arrayS = s.toCharArray();
 for(int i = 0 ; i < arrayS.length ;  i++)
 {
  int Val1 = dict.get(arrayS[i]);
  if(i < arrayS.length -1)
  {
   int Val2 = dict.get(arrayS[i+1]);
   if(Val1 < Val2)
   {
    sum += Val2 - Val1;
    i++;
   }
   else
    sum += Val1;
  }
  else
   sum += Val1;
 }
 return sum;
}