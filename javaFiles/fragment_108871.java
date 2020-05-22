import javafx.beans.Observable;
import javafx.beans.binding.DoubleExpression;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;

public class SomeClass {

  private final ReadOnlyDoubleWrapper total = new ReadOnlyDoubleWrapper(this, "total");
  private void setTotal(double total) { this.total.set(total); }
  public final double getTotal() { return total.get(); }
  public final ReadOnlyDoubleProperty totalProperty() { return total.getReadOnlyProperty(); }

  private final ObservableSet<DoubleProperty> propertySet = FXCollections.observableSet();

  public SomeClass() {
    propertySet.addListener(this::propertySetInvalidated);
  }

  private void propertySetInvalidated(Observable observable) {
    if (propertySet.isEmpty()) {
      total.unbind();
      setTotal(0.0);
    } else if (propertySet.size() == 1) {
      total.bind(propertySet.iterator().next());
    } else {
      DoubleExpression sum = null;
      for (DoubleProperty property : propertySet) {
        sum = (sum != null) ? sum.add(property) : property;
      }
      total.bind(sum);
    }
  }

}