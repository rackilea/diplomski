String command = ReadString();
   String words[]=new String[4];
   String[] n = command.split(" ");

   for(int i=0; i< 4; i++)
    {
      if((n.length-1)==i)
      {
         words[i]=n[i];
      }
      else
      {
         words[i]="empty";
      }
    }