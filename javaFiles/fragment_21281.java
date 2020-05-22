public static String findSubString(String s, String t)
{
    //algorithm moves a sliding "current substring" through s
    //in this map, we keep track of the number of occurrences of
    //each target character there are in the current substring

    Map<Character,int[]> counts = new HashMap<>();
    for (char c : t.toCharArray())
    {
        counts.put(c,new int[1]);
    }

    //how many target characters are missing from the current substring
    //current substring is initially empty, so all of them
    int missing = counts.size();

    //don't waste my time
    if (missing<1)
    {
        return "";
    }

    //best substring found
    int bestStart = -1, bestEnd = -1;

    //current substring
    int start=0, end=0;
    while (end<s.length())
    {
        //expand the current substring at the end
        int[] cnt = counts.get(s.charAt(end++));
        if (cnt!=null)
        {
            if (cnt[0]==0)
            {
                --missing;
            }
            cnt[0]+=1;
        }
        //while the current substring is valid, remove characters
        //at the start to see if a shorter substring that ends at the
        //same place is also valid 
        while(start<end && missing<=0)
        {
            //current substring is valid
            if (end-start < bestEnd-bestStart || bestEnd<0)
            {
                bestStart = start;
                bestEnd = end;
            }
            cnt = counts.get(s.charAt(start++));
            if (cnt != null)
            {
                cnt[0]-=1;
                if (cnt[0]==0)
                {
                    ++missing;
                }
            }
        }
        //current substring is no longer valid.  we'll add characters
        //at the end until we get another valid one
        //note that we don't need to add back any start character that
        //we just removed, since we already tried the shortest valid string
        //that starts at start-1

    }
    return(bestStart<=bestEnd ? s.substring(bestStart,bestEnd) : null);
}