List<String> tokens = new ArrayList<String>();

String text = "Samsung Galaxy S Two";
StringTokenizer st = new StringTokenizer(text);

    //("---- Split by space ------");
    while (st.hasMoreElements()) {
        tokens.add(st.nextElement().toString());
    }

    String search = "axy";
    for(int i=0;i<tokens.size();i++)
    {
        if(tokens.get(i).contains(search))
        {
            System.out.println("Word is "+tokens.get(i));
            break;//=====> Remove Break if you want to continue searching all the words which contains `axy`
        }
    }

output====>Galaxy