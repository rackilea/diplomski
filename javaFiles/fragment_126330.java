public Perk getPerk(ArrayList<Perk> perks) {
    Perk tempPerk = new Perk();
    Perk newMPerk = new Perk();
    ArrayList<Perk> tempPerks = new ArrayList();
    tempPerks.clear();
    int random = Menu.randInt(1, 100);
    for (int i = 0; i < perks.size(); ++i) {
        if (hasRar(perks.get(i), random)) {
            tempPerks.add(perks.get(i));
        }
    }
    if (tempPerks.isEmpty() == false) {
        int nextRandom = Menu.randInt(0, tempPerks.size() - 1);
        tempPerk = tempPerks.get(nextRandom);
        newMPerk.name = tempPerk.name;
        newMPerk.cost = tempPerk.cost;
        newMPerk.rarity = tempPerk.rarity;
        newMPerk.minusDec = tempPerk.minusDec;
        newMPerk.plusInc = tempPerk.plusInc;
        newMPerk.rewardBonus = tempPerk.rewardBonus;

    } else {
        Perk newPerk = new Perk();
        newPerk.name = "Extra";
        newPerk.cost = 0;
        newPerk.rarity = 1;
        newPerk.minusDec = 0;
        newPerk.plusInc = 0;
        newPerk.rewardBonus = 0;
        newMPerk = newPerk;
    }
    return newMPerk;
}