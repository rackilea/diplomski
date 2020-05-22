Human human = null;
while (input.hasNext()) {
    String text = input.nextLine();
    String[] parts = text.split(",");
    if (parts.length == 7) {
        //...
    } else if (parts.length == 5) {
        if (human != null) {
            // Parse pet properties
            Pet pet = new Pet(name, type, age, date1, date2);
            human.add(pet);
        } else {
            throw new NullPointerException("Found pet without human");
        }
    }