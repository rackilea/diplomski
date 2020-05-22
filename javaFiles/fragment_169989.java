import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

@XmlDiscriminatorValue("bird")
public class Bird extends Animal {

    private String wingSpan;
    private String preferredFood;

}