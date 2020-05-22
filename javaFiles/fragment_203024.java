for (int i =0; i<uA;i++) 
     {
        Scanner in = new Scanner(System.in);//scanner inside loop
        System.out.print("Question #"+(i+1)+": ");
        userInput = in.nextLine();
        in.close();//already mentioned by someone in the comment
        int len = userInput.length();
        char[] userAnswers = new char [len];//no need to declare array inside loop
        for(int x =0;x<len;x++) 
        {
           userAnswers[i] = userInput.toUpperCase().charAt(i);
        }
  }

    System.out.println(userAnswers);//this will not print the array,it will print 
    //something like [I@8428 ,[ denotes 1D array,I integer,and the rest of it has 
     //some meaning too