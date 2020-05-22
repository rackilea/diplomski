import java.util.function.*;
import java.util.*;
import java.util.stream.*;

class Task {}

class Assertion extends Task {}

class TaskCollection<E extends Task, C extends TaskCollection<E, C>> extends HashSet<E> {

    <K> Map<K, C> groupBy(Function<E, K> groupingFunction) {
        return this.stream()
            .collect(Collectors.groupingBy(
                    groupingFunction,
                    Collectors.toCollection(this.collectionSupplier())
            ));
    }

    @SuppressWarnings("unchecked")
    protected Supplier<C> collectionSupplier() {
       return () -> {
         try {
          return (C) this.getClass().newInstance();
         } catch (Exception ex) {
          throw new RuntimeException(String.format("class %s is not a proper TaskCollection", this.getClass()), ex);
         }
      };
    }
}

class AssertionCollection extends TaskCollection<Assertion, AssertionCollection> {
    // This override is not needed any longer although still could
    // be included in order to produce a slightly faster 
    // customized implementation:
    //@Override
    //protected Supplier<AssertionCollection> collectionSupplier() {
    //    return AssertionCollection::new;
    //}
}