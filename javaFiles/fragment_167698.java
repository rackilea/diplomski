public static void createRolette(Population population) throws Exception {
    ArrayList<Integer> rouletteId = new ArrayList<Integer>();
    ArrayList<Integer> rouletteFit = new ArrayList<Integer>();
    int swap;

    for (int i=0; i<populationSize; i++){
        population.getIndividual(i);
        Simulator.allocateTask(i);
        rouletteId.add(i); 
        rouletteFit.add(calcFitness(i)); 
    }

    //Bubble Sort
    for (int i = 0; i < ( rouletteFit.size() - 1 ); i++) {
        for (int j = 0; j < rouletteFit.size() - i - 1; j++) {
            if (rouletteFit.get(j) > rouletteFit.get(j+1))
            {
                swap       = rouletteFit.get(j);
                rouletteFit.set(j, rouletteFit.get(j+1));
                rouletteFit.set(j+1, swap);

                swap       = rouletteId.get(j);
                rouletteId.set(j, rouletteId.get(j+1));
                rouletteId.set(j+1, swap);
            }
        }
    }
}