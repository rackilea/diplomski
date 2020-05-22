@Component
public class Archer extends AbstractHero {
    @BowType
    @Autowired
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;   
    }
}