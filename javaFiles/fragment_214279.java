int random=generator.nextInt(2); // return either 0 or 1

    if(random==0){
        return new Tree(x,y);
    }else{
        return new Bush(x, y);
    }