public class TestWrapper implements DatabaseWrapper {
    List<Monster> monsters;
    public TestWrapper() {
        this.monsters = new ArrayList<>();
        this.monsters.add(new Monster("Tim the Tester", 123));
    }
    @Override
    public void saveMonster(Monster monster) {
        this.monsters.add(monster);
    }

    @Override
    public List<Monster> getMonsters() {
        return this.monsters;
    }
}