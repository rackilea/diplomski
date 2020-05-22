<%
    StringBuilder stringBuilder = new StringBuilder();
    BufferedReader reader = request.getReader();
    try 
    {
        String line;
        while ((line = reader.readLine()) != null) 
        {
            stringBuilder.append(line).append('\n');
        }
    } 
    finally 
    {
        reader.close();
    }
System.out.println(stringBuilder.toString());
%>