while(true)
    {
      System.out.println("Input a gender and a name (x_done to quit):");
     String str1 = scan.next();
      if(str1.equals("x_done")){
          break;
      }
     else if(str1.equals("m")){
         test.enqueue(scan.next());
      }
      else if(str1.equals("f")){
          test2.enqueue(scan.next());
      }
   }