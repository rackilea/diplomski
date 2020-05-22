CopyOnWriteArrayList<Hitable> occupantsSnapshot = new CopyOnWriteArrayList<Hitable>(occupants);
    ArrayList<Hitable> removals = new ArrayList<Hitable>();
    Iterator<Hitable> i = occupantsSnapshot.iterator();
    while (i.hasNext()) {
        Hitable hitable = i.next();
        boolean remove = hitable.hit(snakeController);
        if (remove) {//returns true if it should be deleted
            removals.add(hitable);
        }
    }

    for(Hitable hitable: removals){
        occupants.remove(hitable);
        boardController.removeHitable(hitable);
    }