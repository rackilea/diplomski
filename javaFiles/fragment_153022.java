String answer = "";
while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
    answer = readLine("Are you pregnant?");
    if (answer.equalsIgnoreCase("yes")) {
        println("Great! Congratulations ");
        break;
    } else if (answer.equalsIgnoreCase("no")) {
        println("keep trying it will happen."); 
        break;
    } else {
        println("Its a yes or no question");
        readline("are you pregnant? ");
    }    
}