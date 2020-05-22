private int value;
 private final MyValueChangeListener listener;

 public void setValue(int value) {
    if(this.value == value) return;
    listener.changed(this, this.value, value);
    this.value = value;
 }