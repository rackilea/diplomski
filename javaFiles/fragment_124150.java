public void addLamborghini(Lamborghini newLamborghini) {
    if (inventory != null && newLamborghini != null && inventory.size() > 0) {
        for (Lamborghini lambo : inventory) {
            if (lambo == null) {
                inventory.add(newLamborghini);
            }
        }
    }
}