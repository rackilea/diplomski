public class Player {
    private Attack mAttack;

    // Somewhere in your code, you setup something like
    void setFireWeapon(){
        mAttack = new FireAttack();
    }

    // This is where the attack is taken care of
    double inflictDamage() {
        return mAttack.doAttack();
    }
}