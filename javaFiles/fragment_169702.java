public class Sample1 {
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
int i,j,k,len;
    String[] dict= {"how","are","you","something","needs","to","be","done"};
    //StringBuilder str=new StringBuilder("howareyou");
    StringBuilder str=new StringBuilder("somethingneedstobedone");
    len=str.length();
    for(i=0,j=0;i<len;i++) //removed k from here
    {
        for(j=i+1;j<len;j++)
        {
          for (k=0;k<dict.length;k++) { //added this loop!
            if(dict[k].toString().equals(str.substring(i, j)))
            {
                str.insert(j, " ");
            }
          } //Loop closing for k - the dictionary
        }
    }
    System.out.println(str); 
    sc.close();
}