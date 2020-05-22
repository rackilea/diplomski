import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class exercise{
public static void main(String[] args) {

    String s1="home";
    String s2="homework";
    int n=4;
    exercise p=new exercise();

    if(p.hasCheated(s1, s2, n))
    {
        System.out.println("Student Cheated ");
        return;
    }

    System.out.println("Not Cheated");



}

public boolean hasCheated(String s1,String s2, int N)
{
    boolean s3=true;
    ArrayList<String> al=new ArrayList<String>();
    ArrayList<String> bl=new ArrayList<String>();

    al.addAll(getInfo(s1,N));
    bl.addAll(getInfo(s2,N));
    al.retainAll(bl);
    if(al.size()==0)
    {
        s3=false;
    }
    return s3;

}

public List<String> getInfo(String s,int n)
{
    ArrayList<String> inf=new ArrayList<String>();
    inf.clear();
    String myStr=Arrays.toString(s.split("(?<=\\G.{4})"));

    Scanner sc=new Scanner(myStr).useDelimiter(",");
    while(sc.hasNext())
    {
        String myString=sc.next().replaceAll("\\W", "");

        inf.add(myString);
    }

    return inf;
}


}