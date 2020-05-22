int num= Integer.parseInt(br.readLine());
    if (num%2 == 0)
    {
        for (int x=0; x < 5;x++) 
        {    
          System.out.print(num + " ");
          num=num+2;
        }
    }