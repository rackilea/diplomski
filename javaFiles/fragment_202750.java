@Component  
public class Warrior extends AbstractHero {
    @SwordType
    @Autowired
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}