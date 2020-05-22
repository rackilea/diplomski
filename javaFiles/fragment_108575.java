List<String> lstStr = new ArrayList<>();
    str= str.replaceAll("\\s+","");
    StringBuilder temp = new StringBuilder();
    int i;
    for (i=0; i<str.length()-1; i++)
    {

  // actually we looking, if they are same type  
 if(Character.isDigit(str.charAt(i))==Character.isDigit(str.charAt(i+1)))
       {
            temp.append(str.charAt(i));
       }
       else
       {
            temp.append(str.charAt(i));
            lstStr.add(temp.toString());
            temp.setLength(0);// reset StringBuilder to re-use
       }
    }

    temp.append(str.charAt(i));
    lstStr.add(temp.toString());
    System.out.println(Arrays.toString(lstStr.toArray()));