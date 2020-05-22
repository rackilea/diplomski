public void addToCage(Animal animal, int cageId) {
    int nbrCages = cages.size();
    Cage tmp, cage;

    if (nbrCages == 0) {
        cage = new Cage(cageId);
        cage.setAnimal(animal);
        this.cages.add(cage);
    } else {

        boolean cageInUse = false;

        for (int i = 0; i < nbrCages; i++) {
            tmp = cages.get(i);
            if (tmp.getId() == cageId) {
                System.out.println("cage is full");
                cageInUse = true;
                break;
            }
        }

        if (!cageInUse) {
            cage = new Cage(cageId);
            cage.setAnimal(animal);
            this.cages.add(cage);
        }
    }
}