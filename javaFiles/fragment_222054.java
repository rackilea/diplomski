public static String combine(String str1,String str2)
    {

        int l1=str1.length();
        int l2=str2.length();
        String strnew="";
        if(l1>=l2)
        {
            for(int j=0;j<l1;j++)
            {
                char c1=str1.charAt(j);
                strnew=strnew+c1;
                for(int p=j;p<=j && p<l2;p++)
                {
                    char c2=str2.charAt(p);
                    strnew=strnew+c2;
                }
            }
        }
        else
        {
            for(int j=0;j<l2;j++)
            {
                char c1=str1.charAt(j);
                strnew=strnew+c1;
                for(int p=j;p<=j && p < l1;p++)
                {
                    char c2=str2.charAt(p);
                    strnew=strnew+c2;
                }
            }
        }
        return strnew;

    }
}