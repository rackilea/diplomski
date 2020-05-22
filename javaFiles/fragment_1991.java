public class Monster {
    private String name;
    private MyDate dateOfBirth;
    private Weapon weapon;

    public Monster(String name, int day, int month, int year, String weaponName) {
       this.name = name;
       this.dateOfBirth = new MyDate(year, month, day);
       this.weapon = new Weapon(weaponName);
    }
}