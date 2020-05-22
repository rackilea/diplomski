while (line != null)
  {
    for (int i = 0; i < line.length(); i++)
    {
      if (!Character.isWhitespace(line.charAt(i)))
         count ++;
      line = br.readLine();
    }
    System.out.println(count);
  }