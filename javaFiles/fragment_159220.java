try{
 do{
    String q = scoreInput.nextLine();
    if(q.equals("q"){
       //Do something, like break
       break; 
    }

 int numVal = Integer.valueOf(q); 

 scores.addQuiz(numVal); 
} catch (Exception e){
 //Handle error of converting string to int
}
}while(true); 
//Once you have all the scores, be sure to call your averageScore method
averageScore();