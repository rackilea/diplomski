enum Monster {
    GOLD(1),
    SILVER(3),
    BRONZE(6) // pseudo probabilities

    private int weight;
    // constructor etc..
}

public Monster getMonsterSpecial() {
    List<Monster> monsters = new ArrayList<>();

    for(Monster monsterType : Monster.values()) {
        monsters.addAll(Collections.nCopies(monsterType.getWeight(), monsterType)); 
    }

    int winIndex = random.nextInt(monsters.length);
    return monsters.get(winIndex);
}