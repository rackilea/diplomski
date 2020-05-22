@Entity
public class SomeEntity {

    @Column(name = "Special_Char")
    private SpecialCharacter specialCharacter;

    public SpecialCharacter getSpecialCharacter() {
        return this.specialCharacter;
    }

    public void setSpecialCharacter(SpecialCharacter specialCharacter) {
        this.specialCharacter = specialCharacter;
    }
}