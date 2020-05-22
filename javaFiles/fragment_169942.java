Cave cave = new Cave();

// Loop adds several Parties to the cave's party list
cave.parties.add(new Party("FirstParty")); // all anonymously added
cave.parties.add(new Party("SecondParty"));
cave.parties.add(new Party("ThirdParty"));

for (Party p : cave.parties) {
    if (p.name.equals("SecondParty") {
        p.index = ...;
        break;
    }
}