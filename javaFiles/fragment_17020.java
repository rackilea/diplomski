@Entity
@Access(AccessType.PROPERTY)
public class JpaPerson extends CommonPerson {

    @OneToMany(mappedBy="petOwner")
    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

}