@Entity
@Access(AccessType.FIELD)
public class Element<T> {

   @Transient
   private T value;

   @Access(AccessType.PROPERTY)
   private SpecificValue getValue() {
       return (SpecificValue) value;
   }

   private void setValue(SpecificValue v) {
       this.value = (T) v;
   }

...

@Embeddable
public class SpecificValue {

...