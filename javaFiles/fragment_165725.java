if( variableValue != previousValue && this.variableChangeListener != null) {
       // call the listener here, note that we don't want to a strong coupling
       // between the listener and where the event is occurring. With this pattern
       // the code has the flexibility of assigning the listener
       this.variableChangeListener.onVariableChanged(variableValue);
   }