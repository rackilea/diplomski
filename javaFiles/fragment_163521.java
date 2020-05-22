else {
        List<Actor> movieActors = (List<Actor>) x.getListOfActors();
        for (int z = 0; z < x.getListOfActors().size(); z++) {
            Actor actor = movieActors.get(z);
            if (actors.contains(actor)) {
                actors.get(actors.indexOf(actor)).addCount();
            }else{
                actors.add(actor);
            }
        }
    }