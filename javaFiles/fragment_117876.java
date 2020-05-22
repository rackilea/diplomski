enum AllBonuses{
    Bonus1(BonusClass1::new),
    // ...
    Bonus9(BonusClass9::new);

    private final Supplier<Bonus> bonus;
    AllBonuses(Supplier<Bonus> bonus) { this.bonus = bonus; }
    public Bonus create() { return bonus.get(); }
}

// Usage:
int randomNumber = generateRandomNumber(AllBonuses.values().length);
Bonus randomBonus = AllBonuses.values()[randomNumber].create();