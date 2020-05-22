public Dog[] obtainDogsWhoLikeBones() {    

    // Initialise dogsWhoLikeBones list
    ArrayList<Dog> dogsWhoLikeBones = new ArrayList<Dog>();

    // Iterate through dogs
    for (Dog dog : dogs){
        if(dog.getLikesBones()){
            // If a dog likes bones, add them to the list
            dogsWhoLikeBones.add(dog);
        }
    }

    // Get size of list to set the size of the return array
    int listSize = dogsWhoLikeBones.size();

    // Convert dogs list back to an array
    return dogsWhoLikeBones.toArray(new Dog[listSize]);
}