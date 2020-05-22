FileReader file=new FileReader("D:\\Test.txt");
    BufferedReader br=new BufferedReader(file);
    String str;
    Set<String> st=new HashSet<String>();
    while((str=br.readLine())!=null)
    {
         st.add(str);
    }