public class Enemy{
    Attack[] attacks;
    int[] stats;

    public Enemy(int[] stats, Attack[] attacks) {
        this.stats = stats;
        this.attacks = attacks;
    }

    public attack(attackNo) {
        this.attacks[attackNo].execute(stats);
    }
}

public class Attack{
    public execute(int[] stats) {

    }
}