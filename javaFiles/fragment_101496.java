for (int j=0; j < shortDNA.length(); j++)
    {
        currentCharLong=longDNA.charAt(a)+ "";
        currentCharShort=shortDNA.charAt(j)+ ""; 

        if ( (currentCharShort.equalsIgnoreCase("a") && currentCharLong.equalsIgnoreCase("t"))||
            (currentCharShort.equalsIgnoreCase("t") && currentCharLong.equalsIgnoreCase("a"))||
            (currentCharShort.equalsIgnoreCase("c") && currentCharLong.equalsIgnoreCase("g"))||
            (currentCharShort.equalsIgnoreCase("g") && currentCharLong.equalsIgnoreCase("c")) )
        {
            match +=1;
            a +=1;
        }
        else break;
    }