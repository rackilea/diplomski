StringTokenizer st = new StringTokenizer(str);
    int numofTokens = st.countTokens();
    while( st.hasMoreElements() )
    {   
        String TOKEN = st.nextToken();
        for (int i = 0; i < reserved_Keywords.length; i++)
        {  
            if ( TOKEN.equals(reserved_Keywords[i]) )
            {  
                System.out.print(st.nextElement() + "\t");
                System.out.println("Is Reserved Keyword");
            }
        }