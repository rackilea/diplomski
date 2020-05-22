public static LinkedList<String> findTheLongestSubstring(String s1, String s2)
    {
        LinkedList<String> allFound = new LinkedList<String>();
        String theLongest="";
        if(s1.length()>s2.length())
        {
            s1 = s1 + s2;
            s2 = s1.substring(0, (s1.length() - s2.length()));
            s1 = s1.substring(s2.length());
        }
        for(int j=0;j<s1.length();j++)
        {
            for(int i=s1.length()-j; i>=0;i--)
            {
                if(s1.substring(j,j+i).length()>=theLongest.length() && s2.contains(s1.substring(j,j+i)))
                {
                    theLongest = s1.substring(j, j+i);
                    // before adding any string check the length of existing string if it is less then remove it
                    if (allFound.size() > 0 && allFound.getFirst().length() < theLongest.length()) {
                        allFound.removeFirst();
                    }
                    allFound.add(theLongest);
                }
            }
        }

        return allFound;
    }