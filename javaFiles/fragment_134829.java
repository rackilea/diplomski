// Lives in android/src
public class SugarMonster extends SugarRecord<SugarMonster> {
    public String name;     // prénom
    public int hitpoints;   // points de dommage

    public SugarMonster() {
    }

    public SugarMonster(Monster monster) {
        this.name = monster.name;
        this.hitpoints = monster.hitpoints;
    }
}