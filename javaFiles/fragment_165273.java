public class mainComposer extends GenericForwardComposer{
  Combobox combo; //ZK Auto Wired , use combo directly
  public void onChanging$combo() { // ZK Autoforward (Awesome !!)
    suggest();
  }
  public void suggest() {    
    combo.getItems().clear();
    combo.appendItem("Ace");
    combo.appendItem("Ajax");
    combo.appendItem("Apple");
    combo.appendItem("Best");
    combo.appendItem("Blog");
  }

}