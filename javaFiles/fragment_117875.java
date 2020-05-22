ArrayList<Supplier<Bonus>> bonuses = new ArrayList<>();
    bonuses.add(Bonus1::new);
    // ...
    bonuses.add(Bonus9::new);
    int randomNumber = generateRandomNumber(bonuses.size());
    Bonus randomBonus = bonuses.get(randomNumber).get();