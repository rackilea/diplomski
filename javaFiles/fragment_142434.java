@XmlRootElement(name="car")
...
public class Car {
   ...

   @XmlElementWrapper(name="recalls")  // this name=... can be omitted, as it
                                       // is the same as the field name
   @XmlElement(name="recall")
   private ArrayList<Recall> recalls;
}