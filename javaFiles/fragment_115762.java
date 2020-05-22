StringBuffer rowBuffer = new StringBuffer(row);
    int startIndex = 0;
    int endIndex = rowBuffer.indexOf(",") - 1;
    rowBuffer.deleteCharAt(rowBuffer.indexOf("["));
    rowBuffer.deleteCharAt(rowBuffer.indexOf("]"));
    while(startIndex != -1 && endIndex != -1 && startIndex < endIndex)
    {
      String subString = rowBuffer.substring(startIndex, endIndex);

       if(subString.contains(","))
       {
          rowList.add(" ");
          startIndex = endIndex - 1;
          endIndex = rowBuffer.indexOf(", ", startIndex + 1);
       }

       else
       {
         if(subString.equals("1"))
             rowList.add("True");
         else if(subString.equals("0"))
             rowList.add("False");
         else
          rowList.add(subString);
        startIndex = endIndex + 2;
        endIndex = rowBuffer.indexOf(",", startIndex + 1);
       }

       if(endIndex == -1)
       {
          if(subString.equals("1"))
             rowList.add("True");
          else if(subString.equals("0"))
             rowList.add("False");
          break;
       }
    }