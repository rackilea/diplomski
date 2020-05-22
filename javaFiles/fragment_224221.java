import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="AnimalList")
public class AnimalList {

    private List<Animal> animalList = new ArrayList<Animal>();

    @XmlElement(name="Animal")
    @XmlJavaTypeAdapter(AnimalAdapter.class)
    public List<Animal> getEntries() {
        return animalList;
    }

}