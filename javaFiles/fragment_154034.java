// way up above everything
public boolean toggleState=false;

// then later
SVelRand.addItemListener(new ItemListener() {
public void itemStateChanged(ItemEvent e) {
  this.toggleState=(!this.toggleState);
  String message=(this.toggleState) ? "checked" : "unchecked";
  System.out.println("Checkbox is "+message);
}
});