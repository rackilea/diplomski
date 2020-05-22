private String crossover(String parent1, String parent2){

    String child = "";
    for(int i = 0; i < parent1.length(); i++){
        if (rand.nextFloat() >= 0.5){
            child += parent1[i];
        }
        else {
            child += parent2[i];
        }
    }
}