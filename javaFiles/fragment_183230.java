int num= Integer.parseInt(br.readLine());
    int loopTo = 10;
    if (num%2 == 0)
    {
       loopTo = 5;
    }

     for (int x=0; x < loopTo;x++) 
     {    
          System.out.print(num + " ");
          num=num+2;
     }