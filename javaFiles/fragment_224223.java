import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class AnimalExtension extends Animal {

    private int animalId;

    @XmlAttribute(name="id")
    @XmlJavaTypeAdapter(IdAdapter.class)
    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

}