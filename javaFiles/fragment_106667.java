//Create list for index 
ArrayList<Integer>answerIndexList=new ArrayList<Integer>();


//get char index
for (int i=0;i<logic.line.length();i++){
    if(logic.line.charAt(i) == answer){
        answerIndexList.add(i);
     }
}


//replace index with answer
for(int i=0;i<answerIndexList.size();i++){

    guessedChar.setCharAt(answerIndexList.get(i), answer);
}

logic.newLine = guessedChar.toString();