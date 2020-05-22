public double averageScore(){
   if(scores != null){
     for(int score : scores){
        totalScore += score; 
     }
     return totalScore/scores.size(); 
}