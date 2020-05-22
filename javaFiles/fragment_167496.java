public class TrainingCamp {

    public static int trainedJavaGuys ;
    public static int trainedPHPGuys ;

    // Declare once
    ArrayList<Integer> trainingListJava; 
    ArrayList<Integer> trainingListPHP;

    public TrainingCamp() {
        // Initialize once
        trainingListJava = new ArrayList<>();
        trainingListPHP = new ArrayList<>();
    }

    public void trainedTroopsInCamp(int java,int php){
        // Use everywhere
        trainingListJava.add(java);
        trainedJavaGuys = sumList(trainingListJava);

        trainingListPHP.add(php);
        trainedPHPGuys = sumList(trainingListPHP);
    }
}