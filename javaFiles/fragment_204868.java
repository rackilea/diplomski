ga_ newSpecies = new ga_();
    Random r= new Random(10);
    ga_struct father= new ga_struct();//instantiate father
    father.gene="123";
    newSpecies.vector.add(father);

    for (int i = 1; i < 10; i++) {
        ga_struct ng = new ga_struct();//create new instance for child
        ng=newSpecies.mutate(father);//set ng as reference to same instance as father, instance instantiated on previous line is discarded
        ng.fitness=i;
        newSpecies.vector.add(ng);
        father=ng;          
        System.out.println(newSpecies.vector.get(i).gene+" with fitness factor "+newSpecies.vector.get(i).fitness);

    }