import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

@XmlDiscriminatorValue("Bird")
class Bird extends Animal {
    public String wingSpan;
    public String preferredFood;
}