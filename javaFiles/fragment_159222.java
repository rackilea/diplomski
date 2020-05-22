public class Student {
   private String name;
   private int numOfQuizzes;
   private double totalScore;
   private ArrayList<Integer> scores;

   public Student(String name){
       this.name = name;
       scores = new ArrayList<Integer>();
   }

   public String getName() {
       return name;

   }public void addQuiz(int score){
        scores.add(score); 
   }

   public double getTotalScore() {
       for(int score : scores){
           totalScore += score; 
       }
       return totalScore;
   }

public double averageScore(){
   if(scores != null){
     for(int score : scores){
        totalScore += score; 
     }
     return totalScore/scores.size(); 
}
}