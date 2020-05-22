class Hayyan {
    public static void main(String[] args) {
        CombatHayyan combatHayyan = new CombatHayyan();

        Scanner scanner = new Scanner(System.in);
        while (combatHayyan.bothCombatantsAlive()) {
            System.out.println("Choose a weapon to attack with, type sword for a sword, or axe for an axe ");
            combatHayyan.attack(scanner);
            combatHayyan.defend();
            System.out.println();
        }

        scanner.close();
        combatHayyan.printWinner();
    }
}

class CombatHayyan {
    public int enemyHP = 50;
    public int yourHp = 100;

    Weapons weapon = new Weapons();

    public void attack(Scanner scanner) {
        int damage = 0;
        switch (scanner.nextLine()) {
        case "sword":
            damage = weapon.sword();
            break;

        case "axe":
            damage = weapon.axe();
            break;
        }
        enemyHP = enemyHP - damage;
        System.out.println("Enemy now has " + enemyHP + "HP left!");
    }

    public void printWinner() {
        String winner = yourHp>0?"You":"The enemy";
        int hp = yourHp>0?yourHp:enemyHP;
        System.out.println(winner + " won! with " + hp + "HP remaining");
    }

    public boolean bothCombatantsAlive() {
        return enemyHP > 0 && yourHp > 0;
    }

    public void defend() {
        Random random = new Random();
        int randomness = random.nextInt(11) + 10;
        yourHp = yourHp - randomness;
        System.out.println("You now have " + yourHp + "HP left!");

    }
}

class Weapons {
    public int sword() {
        return 5 + (int) (Math.random() * ((10 - 5) + 1));
    }

    public int axe() {
        return 5 + (int) (Math.random() * ((10 - 5) + 1));
    }
}