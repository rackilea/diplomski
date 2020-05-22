// Lives in android/src
public class SugarWrapper implements DatabaseWrapper {
    @Override
    public void saveMonster(Monster monster) {
        SugarMonster data = new SugarMonster(monster);
        data.save();
    }

    @Override
    public List<Monster> getMonsters() {
        List<SugarMonster> records = SugarMonster.listAll(SugarMonster.class);
        ArrayList<Monster> monsters = new ArrayList<>();
        for(SugarMonster record : records) {
            monsters.add(new Monster(record.name, record.hitpoints));
        }
        return monsters;
    }
}