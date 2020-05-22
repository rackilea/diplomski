Collections.sort(str, new Comparator<String>(){                    
    public int compare(String str1, String str2){
      int result = 0;
      int i = 0;
      String [] s1 = str1.split(",");
      String [] s2 = str2.split(",");
      while ((i < s1.length) && (i < s2.length) && (result == 0)){
        result = (Integer.parseInt(s1[i]) - Integer.parseInt(s2[i]));
        i++;        
      }
      return (result);
    }
});