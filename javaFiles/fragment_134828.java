// Lives in core
// Replace with your application
public class LibGDXTestbed extends ApplicationAdapter {
    DatabaseWrapper database;

    public LibGDXTestbed() { } // For platforms that don't have databases to inject.

    public LibGDXTestbed(DatabaseWrapper database) {
        this.database = database;
    }

    /**
     * For demo purposes, add a new randomized monster to the database, then log a list of all the
     * monsters created to date.
     */
    @Override
    public void create () {
        if(database != null) {
            createMonster();
            printMonsters();
        } else {
            Gdx.app.error("WARNING", "No database provided. Load/Save Functionality Disabled.");
        }
    }

    // Helper method
    private void createMonster() {
        // Create a set of names we can use for new monsters.
        String[] names = {"Fred", "Mary", "Jean", "Tim"};

        String randomName = new Array<String>(names).random();
        int randomHP = MathUtils.random(100);
        database.saveMonster(new Monster(randomName, randomHP));
    }

    // Helper method
    private void printMonsters() {
        for(Monster monster : database.getMonsters()) {
            Gdx.app.log("DEBUG", monster.toString());
        }
    }
}