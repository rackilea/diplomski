public String[][] getArrayNoZero(String[][]s)
   {
     java.util.List<String[]> result=new java.util.ArrayList<String[]>();
     for(int i=0; i<s.length; i++)
     {
     if(!s[i][1].equals("0.0"))
       {
        String []tempArray= {s[i][0],s[i][1]};
        result.add(tempArray);
       }
     }
    return result.toArray(new String[0][0]);
 }