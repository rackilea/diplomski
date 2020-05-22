Scanner input = new Scanner(new File("data.txt"));
List<Human> humans = new ArrayList<>(25);
Human human = null;
while (input.hasNext()) {
    String text = input.nextLine();
    String[] parts = text.split(",");
    if (parts.length == 7) {
        String firstName = parts[0];
        String lastName = parts[1];
        String address = parts[2];
        int cid = Integer.parseInt(parts[3]);
        int vists = Integer.parseInt(parts[4]);
        double balance = Double.parseDouble(parts[5]);
        int other = Integer.parseInt(parts[6]);
        human = new Human(firstName, lastName, address, cid, vists, balance, other);
        humans.add(human);
    } else if (parts.length == 5) {
        if (human != null) {
            String name = parts[0];
            String type = parts[1];
            int age = Integer.parseInt(parts[2]);
            String date1 = parts[3];
            String date2 = parts[4];
            Pet pet = new Pet(name, type, age, date1, date2);
            human.add(pet);
        } else {
            throw new NullPointerException("Found pet without human");
        }
    }
}