//Get Names of Roommates
    for(i = 0; i < roommates.length; i++){
        System.out.print("What is Person Number " + (i + 1) + "'s Name:  ");
            if(input.hasNext()){
               roommates[i] = input.nextLine();
               input.next();
            }
    }