class Fighter {
    int hp;

    void attack() {

    }

    void move() {

    }

    void regen() {
        hp++;
    }
}

class MagicFighter extends Fighter {
    int mana;

    @Override
    void regen() {
        mana++;
        //we don't regen hp because we're magic-type.
    }
}

class StrengthFighter extends Fighter {
    int rage;

    @Override
    void attack() {
        super.attack();
        specialRegen();
    }

    void specialRegen() {
        rage++;
    }

    @Override
    void regen() {
        // does nothing
    }

    void berserk() {
        rage--;
    }
}