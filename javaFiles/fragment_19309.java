TreeSet<Pet> sortedPets = new TreeSet(new Comparator<Pet>() {                                         
    public int compare(Pet p1, Pet p2) {
        return p1.getName().compareTo(p2.getName());
    }
});
sortedPets.addAll(myPets);