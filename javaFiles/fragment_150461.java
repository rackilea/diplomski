for (int i = 0; i < p; i++) {
        parent1 = rand.nextInt(p); //randomly choose parent
        parent2 = rand.nextInt(p); //randomly choose parent

        if (population[parent1].fitness >= population[parent2].fitness) {
            offspring[i] = population[parent1].clone();
        } else {
            offspring[i] = population[parent2].clone();
        }
    }