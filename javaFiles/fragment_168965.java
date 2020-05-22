class Zebra extends Mammal { }

List<Giraffe> giraffes = new List<Giraffe>();

List<Mammal> mammals = giraffes; // not allowed

mammals.add(new Zebra()); // would add a Zebra to a list of Giraffes