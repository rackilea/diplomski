import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Test1
{
    public static void main(String[] args)
    {
        String string1="world world is new world of kingdom of palace of kings palace";
        String string2[]=string1.split(" ");
        HashMap<String, Integer> uniques = new HashMap<String, Integer>();
        for (String word : string2)
        {
            // ignore words 2 or less characters long
            if (word.length() <= 2)
            {
                continue;
            }
            // add or update the word occurrence count
            Integer existingCount = uniques.get(word);
            uniques.put(word, (existingCount == null ? 1 : (existingCount + 1)));
        }

        Set<Entry<String, Integer>> uniqueSet = uniques.entrySet();
        boolean first = true;
        for (Entry<String, Integer> entry : uniqueSet)
        {
            if (entry.getValue() > 1)
            {
                System.out.print((first ? "" : ", ") + entry.getKey() + "=" + entry.getValue());
                first = false;
            }
        }

    }
}