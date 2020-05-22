// Please ignore the fact that I am using the System.in stream in this example.
try(BufferedReader br = new BufferedReader( new InputStreamReader( System.in) ))
  {

    String line;
    StringBuilder sb = new StringBuilder();
    // Read lines until null (EoF / End of File / End of Stream)
    while((line = br.readLine()) != null)
     {
       // append the line we just read to the StringBuilds buffer
       sb.append(line);
     }
    // Print the StringBuilders buffer as String.
    System.out.println(sb.toString());
  }
  catch ( IOException e )
  {
    e.printStackTrace();
    // Exception handling in general...
  }