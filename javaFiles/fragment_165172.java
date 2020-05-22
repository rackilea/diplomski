public static void main (String[] args) {
    Dog Kvist = new Dog("Vuf!", 8, "yes");
    Dog Snoop = new Dog("Doggy Dogg World!", 48, "yes");
    Dog Greta = new Dog("We need change now!", 17, "no");

    Dog[] dogs = {Kvist, Snoop, Greta};

    //How do I translate the next 3 lines to a for-loop? #StillLearning
    for (int i = 0; i < dogs.length; i++)
    {
        dogs[i].gender = dogs[i].whatGender(dogs[i].gender);
    }
    // Kvist.gender = Kvist.whatGender(Kvist.gender);
    // Snoop.gender = Snoop.whatGender(Snoop.gender);
    // Greta.gender = Greta.whatGender(Greta.gender);