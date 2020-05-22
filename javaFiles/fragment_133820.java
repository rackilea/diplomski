short[] docsofword = new short[8349328];

    br2 = new BufferedReader(new FileReader("TermOccurrenceinCollection.txt"));             
    ss = br2.readLine();
    int strIndex, index;
    while(ss!=null)
    {
       strIndex = ss.indexOf( ' ' );
       index = Integer.parseInt(ss.subStr(0, strIndex));
       docsofword[index] = Short.parseShort(ss.subStr(strIndex+1));
       ss = br2.readLine();
    }
br2.close();