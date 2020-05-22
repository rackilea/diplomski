public static void getStringTripple(String a){      
          String s[]=a.split(" ");
          List<String> asList = Arrays.asList(s);
          Map<String, Integer> unique = new LinkedHashMap<String, Integer>();
          String string="";
       for(int i=0;i<asList.size();i++){
       for(int j=i;j<s.length;j++){
           string+= asList.get(j);
         if(unique.get(string) == null)
            unique.put(string, 1);
        else
            unique.put(string, unique.get(string) + 1);
          }
       string="";
    }
    String uniqueString = join(unique.keySet(), ", ");
    List<Integer> value = new ArrayList<Integer>(unique.values());


    System.out.println("Output = " + uniqueString);
    System.out.println("Values = " + value);

}