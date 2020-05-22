import java.util.HashSet;
import java.util.Set;

public class PowerSet
{

    static boolean getBit(int i, int pos) {return (i&1<<pos)>0;}

    static Set<Set<Character>> powerSet(String s)
    {
        Set<Set<Character>> pow = new HashSet<>();
        for(int i=0;i<(2<<s.length());i++)
        {
            Set<Character> subSet = new HashSet<>();
            for(int j=0;j<s.length();j++)
            {
                if(getBit(i,j)) {subSet.add(s.charAt(j));}
            }
            pow.add(subSet);
        }
        return pow;

    }

    public static void main(String[] args)
    {System.out.println(powerSet("xyz"));}

}