a_ newSpecies = new ga_();
    Random r= new Random(10);
    ga_struct father= new ga_struct();
    father.gene="123";
    newSpecies.vector.add(father);

    for (int i = 1; i < 10; i++) {    
        ga_struct ng=newSpecies.mutate(father);
        ng.fitness=i;
        newSpecies.vector.add(ng);
        father=ng;          
        System.out.println(newSpecies.vector.get(i).gene+" with fitness factor "+newSpecies.vector.get(i).fitness);

    }

    newSpecies.sortspecies();
    System.out.println("\ncurrent population\n");

    for (int i = 0; i < 10; i++) {
        System.out.println(newSpecies.vector.get(i).gene+" with fitness factor "+newSpecies.vector.get(i).fitness);
    }