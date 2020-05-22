@Entity
public class CreatureTypeWeapon implements Serializable {

    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "creature_id", referencedColumnName = "id")
    private CreatureType creatureType;

    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "weapon_id", referencedColumnName = "id")
    private Weapon weapon;
}