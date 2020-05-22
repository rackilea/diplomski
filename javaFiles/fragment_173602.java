@Entity
public class PersonEntity implements Person {
    private Long id;

    private Pet pet;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    @OneToOne(targetEntity = PetEntity.class)
    public Pet getPet() {
        return pet;
    }        

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}