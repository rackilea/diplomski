for(Question question: questions){
    Answer answer = askQuestion(Question)

    if(question.answer = answer)
        showInfo("you are correct, next question will be " + question.num + 1)
    else{
        response = showInfo("you are wrong. do you want to try?")

        if(response = no)
            break;
    }

}
Answer askQuestion(Question question){

    return showQuestion(question);

}