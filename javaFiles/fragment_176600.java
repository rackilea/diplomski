class Solution
{
    private static ArrayList<Character> getCharList (String str)
    {
        return Arrays.asList(str.getCharArray());
    }

    private static void findFirst (String a, String b, String c)
    {
        int cursor = 0;
        int start = -1;
        int end = -1;

        ArrayList<Character> stream = getCharList(a);
        ArrayList<Character> lookup = getCharList(b);
        ArrayList<Character> avoid = getCharList(c);

        for(Character ch : stream)
        {
            if (avoid.contains(ch))
            {
                lookup = getCharList(b);
                start = -1;
                end = -1;
            }
            else
            {
                if (lookup.contains(ch))
                {
                    lookup.remove(ch)

                    if (start == -1) start = cursor;

                    end = cursor;
                }
            }

            if (lookup.isEmpty())
                break;

            cursor++;
        }

        if (lookup.isEmpty())
        {
            System.out.println(" found at ("+start+":"+end+") ");
        }
        else
        {
            System.out.println(" not found ");
        }
    }
}