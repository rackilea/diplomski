public boolean hasAnimals() {
    if(type == 1) {
        return true; // aquarium has animals
    } else if (type == 2) {
        return true; // zoo has animals
    } else {
        return false;
    }
}