import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.WeakChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;

public class SomeClass {

  private final ReadOnlyDoubleWrapper total = new ReadOnlyDoubleWrapper(this, "total");
  private void setTotal(double total) { this.total.set(total); }
  public final double getTotal() { return total.get(); }
  public final ReadOnlyDoubleProperty totalProperty() { return total.getReadOnlyProperty(); }

  private final ObservableSet<DoubleProperty> propertySet = FXCollections.observableSet();
  private final ChangeListener<Number> elementListener = this::elementValueChanged;
  private final WeakChangeListener<Number> weakElementListener =
      new WeakChangeListener<>(elementListener);

  public SomeClass() {
    propertySet.addListener(this::propertySetChanged);
  }

  private void propertySetChanged(SetChangeListener.Change<? extends DoubleProperty> change) {
    if (change.wasRemoved()) {
      change.getElementRemoved().removeListener(weakElementListener);
      setTotal(getTotal() - change.getElementRemoved().get());
    }
    if (change.wasAdded()) {
      change.getElementAdded().addListener(weakElementListener);
      setTotal(getTotal() + change.getElementAdded().get());
    }
  }

  private void elementValueChanged(ObservableValue<? extends Number> observable,
                                   Number oldValue, Number newValue) {
    setTotal(getTotal() - oldValue.doubleValue() + newValue.doubleValue());
  }

}