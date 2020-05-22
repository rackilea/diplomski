String str="a b c";
    boolean a1 = true ; 
    StringBuilder strbu = new StringBuilder();
    for(int i=0 ; i<str.length();i++)
    {   
        Character b = str.charAt(i);
        if(b.equals(' ') && a1 == true )
        {
            a1 = false;
            strbu = strbu.append("AA");
        }
        else
        {
            strbu = strbu.append(b);
        }
    }
    Log.e("str","string:"+strbu.toString());