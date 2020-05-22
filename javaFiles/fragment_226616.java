public static void RemoveMatchedCharsInnStrings(String first,String second)
    {
        for(int i = 0 ;i < first.length() ; i ++)
        {
            char c = first.charAt(i);
            if(second.indexOf(c)!= -1)
            {
                first = first.replaceAll(""+c, "");
                second = second.replaceAll(""+c, "");
            }
        }
        System.out.println(first);
        System.out.println(second);
        System.out.println(first.length() + second.length());

    }