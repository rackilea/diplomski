String petType;
int lineNumber = 0;

while (input.hasNext()) {
    lineNumber++;    
    try {
        petType = input.next();
        if (petType.equals("BIRD")) {
            String name = input.next();
            String owner = input.next();
            double weight = input.nextDouble();
            boolean clipped = input.nextBoolean();
            Bird x = new Bird(name, owner, weight, clipped);
            object.addPet(x);
        }
    }
    catch (NoSuchElementException nse) {
        System.out.println("something is missing in line " + lineNumber);
    }
}