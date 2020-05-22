package sample; 

import javafx.scene.control.SpinnerValueFactory.IntegerSpinnerValueFactory; 

public final class IntSpinnerValueFactory extends IntegerSpinnerValueFactory { 

  public IntSpinnerValueFactory(final int min, final int max) { 
    super(min, max); 
  } 

  public IntSpinnerValueFactory(final int min, final int max, final int initialValue) { 
    super(min, max, initialValue, 1); 
  } 

  @Override 
  public void increment(final int steps) { 
    final int min = getMin(); 
    final int max = getMax(); 
    final int currentValue = getValue(); 
    final int newIndex = currentValue + steps * getAmountToStepBy(); 
    setValue(newIndex <= max ? newIndex : (isWrapAround() ? (newIndex - min) % (max - min + 1) + min : max)); 
  } 

}