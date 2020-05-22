char[] testAnswers = {'B','D','A','A','C','A','B','A','C','D'};
int uA =testAnswers.length;//to find the length of testAnswers array i.e. 10
char[] userAnswers = new char [uA]; 
char userInput;
int i;
Scanner in = new Scanner(System.in);
for (i =0; i<uA;i++) 
 {           
        System.out.print("Question #"+(i+1)+": ");
        userInput = Character.toUpperCase(in.next().charAt(0));
 }

  for(i=0;i<ua;i++) 
  {
       System.out.println(userAnswers[i]);
  }
  System.out.println("Data has been recorded");