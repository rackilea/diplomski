class Bonus1Factory implements BonusFactory {
    @Override
    public Bonus create() { return new BonusClass1(); }
}
// ...
ArrayList<BonusFactory> bonuses = new ArrayList<>();
bonuses.add(new Bonus1Factory());
// ...