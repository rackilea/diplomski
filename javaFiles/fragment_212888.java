abstract class Criteria {
    abstract String getName();
    String getNameFromSavedCriteria(SavedCriteria s) {
        return s.getName();
    }
}
interface SavedCriteria {
    String getName();
}
public abstract class AbstractSearch<T, C extends Criteria, S extends SavedCriteria> implements Serializable {

   void foo() {
       System.out.println("Hello. Searching for " + getCriteria().getName());
   }
}