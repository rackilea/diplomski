Map<String,String> msgMap = new HashMap<>();
while (line != null) 
    {
       String arr[] = line.split(" ", 2);
       if(arr[0]!=null)
         msgMap.put(arr[0],arr[1]);
       line = reader.readLine();
    }