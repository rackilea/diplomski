Cave cave = new Cave();

// Loop adds several Parties to the cave's party list
cave.parties.put("FirstParty", new Party("FirstParty")); // all anonymously added
cave.parties.put("SecondParty", new Party("SecondParty"));
cave.parties.put("ThirdParty", new Party("ThirdParty"));

if (cave.parties.containsKey("SecondParty")) {
    cave.parties.get("SecondParty").index = ...
}