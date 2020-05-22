import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<String>();
        list.add("netl"); list.add("etnl"); list.add("ltc"); list.add("6.3"); list.add("6.3");
        list.add("maat"); list.add("lo"); list.add("CombiGym"); list.add("mr"); list.add("wisB");
        list.add("nat"); list.add("schk"); list.add("biol"); list.add("6.4"); list.add("6.4");
        list.add("wisD"); list.add("L&W"); list.add("9"); list.add("8.5"); list.add("reken");
        list.add("exp");
        log(list);
        log(updateList(list));
    }

    public static ArrayList<String> updateList(ArrayList<String> list)
    {
        ArrayList<String> ret = new ArrayList<String>();
        for (int i=0; i<list.size(); i++)
        {
            if (i == 0)
                ret.add(list.get(i));
            else
            {
                Pattern p = Pattern.compile("^[0-9]+(\\.[0-9]+)?$");
                Matcher m = p.matcher(list.get(i));
                if (m.find()) ret.set(ret.size()-1, ret.get(ret.size()-1) + " " + list.get(i));
                else ret.add(list.get(i));
            }
        }
        return ret;
    }

    public static void log(ArrayList<String> list)
    {
        String logstr = "[";
        for (int i=0; i<list.size(); i++)
        {
            if (i > 0) logstr += ", ";
            logstr += list.get(i);
        }
        logstr += "]";
        System.out.println(logstr);
    }
}