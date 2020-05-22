public void askQuestion(){
    String response = readline("Do you want to go to a movie tonight?");
    getYesNoResponse(response);
}

public void getYesNoResponse(String answer){
    if (answer.equals("yes"){
        //print the yes response
    } else if (answer.equals("no") {
        //print the no response
    } else {
        askQuestion();
    }
}