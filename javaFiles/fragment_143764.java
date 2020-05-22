// Create the file at path specified in the String str
    // ...
    HashMap<String, Integer> map = new HashMap<>();
    InputStream fis = new FileInputStream(str);
    Reader bufferedReader = new BufferedReader(new InputStreamReader(fis));

    StreamTokenizer st = new StreamTokenizer(bufferedReader);
    st.wordChars('+', '+');
    while(st.nextToken() != StreamTokenizer.TT_EOF) {
        String s;

        switch(st.ttype) {
            case StreamTokenizer.TT_NUMBER:
                s = String.valueOf(st.nval);
                break;
            case StreamTokenizer.TT_WORD:
                s = st.sval;
                break;
            default:
                s = String.valueOf((char)st.ttype);
        }
        Integer val = map.get(s);
        if(val == null)
            val = 1;
        else
            val++;
        map.put(s, val);
    }

    Set<String> keySet = map.keySet();
    Iterator<String> iter = keySet.iterator();
    System.out.println("Frequency Of Words :");
    int sum = 0;
    while(iter.hasNext()) {
        String word = iter.next();
        int count = map.get(word);
        sum += count;
        System.out.println(" WORD : " + word + " = " + count);
    }
    System.out.println("Total Words In Files: " + sum);