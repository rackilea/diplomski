public class ProgramOnStrings {

public static void main(String[] args) {
    // TODO Auto-generated method stub
    Compare cobj=new Compare();
    cobj.compareStrings();
}

}

class Compare
{
String s1="helloworld";
String s2="hord";
int array[];
String small,big;

Compare()
{
    if(s1.length()<s2.length())
      {

          small=s1;
          big=s2;
          array=new int[small.length()];

      }
      else
      {
        small=s2;
        big=s1;
        array=new int[s2.length()];  

      }
    System.out.println("small\t"+small+"\tbig\t"+big);
}

public void compareStrings()
{
    int j=0;
   for(int i=0;i<big.length();i++)
  {

      if(small.charAt(j)==big.charAt(i))
      {
         array[j]=i;
         System.out.println("if: The selected positions are"+i);
        j++;  
      }


  }

  int m=0;
  for(int k=0;k<big.length();k++)
  {
      if(array[m]==k)
      {
          System.out.print(small.charAt(m));
          m++;
      }
      else
      {
      System.out.print("*");
      }
 }
}

}