//initializing variables
          int stop = 0;
          String otherQ,q;

          //initializing array
          String[] responses = {
          "It is certain.",
          "It is decidedly so.",
          "Without a doubt.",      
          "Yes - definitely.",
          "You may rely on it.",
          "As I see it, yes.",
          "Most likely.",
          "Outlook good.",
          "Yes.",      
          "Signs point to yes.",
          "Reply hazy, try again.",
          "Ask again later.",
          "Better not tell you now.",
          "Cannot predict now.",
          "Concentrate and ask again.",      
          "Don't count on it.",
          "My reply is no.",
          "My sources say no.",
          "Outlook not so good.",   
          "Very doubtful."};


          //creates objects
          Scanner scan = new Scanner (System.in);
          Random rn = new Random();

          //input
          //THIS IS WHERE I AM HAVING A PROBLEM.
          do {
              System.out.print("What is your question? ");
              q = scan.nextLine(); 
              System.out.println(responses[rn.nextInt(19)]);  //method caller

              System.out.print("Would you like to ask another question? (Answer yes or no): ");
              otherQ = scan.nextLine(); 

          } while (otherQ.equalsIgnoreCase("yes"));