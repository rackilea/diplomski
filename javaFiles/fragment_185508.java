String[] arrInfo =new String[4];
    for(int i = 0; i < 16; i++)
    {
      line = br.readLine();
      arrInfo[i%4] = line.toString();
      if((i+1)%4 == 0)
      {
        events.add(arrInfo);
        arrInfo =new String[4]; // re-initialize the array
      }
    }