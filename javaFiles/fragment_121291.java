public String sizeOfSupermarket() {
    switch (this.numberOfProducts/1000) {
        case 0: case 1: return "Small";
        case 2: case 3: case 4: return "Medium";
        default: return "Large";
    }
}