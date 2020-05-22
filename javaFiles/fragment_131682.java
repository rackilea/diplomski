public class Dagger extends Blade {

public Dagger() {
super();
damage = 1;
extradamage = -1;
chancetohit = 75;
}

public String attack(int damage, int extradamage, String type) {
   String result1 = super.attack(damage, extradamage, type);
   String result2 =super.attack(damage, extradamage, type);
   return // You can return result1 or result2 based on your requirement
}