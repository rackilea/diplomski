while (true) {
    for(Map.Entry<String, Pokemon> entry : userTeam.team.entrySet()) {
        if(entry.getKey().equals(pickedPokemon)) {
            userTeam.setCurrentPokemon(entry.getValue());
            break outerloop;
        }
    }
    System.out.println("Error: Pokemon not found. Try again.");
}