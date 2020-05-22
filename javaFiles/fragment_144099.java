for (int i = 0; i < n; i++){
    name[i] = JOptionPane.showInputDialog("What is your name player"+ (i+1) +"?");
    JOptionPane.showMessageDialog(null,"Hello :"+ name[i] + " Player number " +(i+1)+ ". I hope your ready to start!");


    score = 0; //reset the score variable
    /* --------------------------- Loop in Loop for questions --------------------------- */ 
    for (int x=0; x<question.length; x++) {
        que[x] = JOptionPane.showInputDialog(question[x]);
        if(que[x].equals(answer[x])){
            score = score + 1;
            System.out.println("\nPlayer"+(i)+ "Name:"+name[i]+"\tScore"+score);
        }
        else{
            JOptionPane.showMessageDialog(null,"Wrong!");
        }
    } // End for loop for Question
    playerscore[i] = score; //assign the score for each player
}