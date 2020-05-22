InputStream inputStream = channelssh.getInputStream(); 

       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

       StringBuilder stringBuilder = new StringBuilder();

       String line;

       while ((line = bufferedReader.readLine()) != null) 
       {

           stringBuilder.append(line);
           stringBuilder.append('\n');

       }

       return stringBuilder.toString();