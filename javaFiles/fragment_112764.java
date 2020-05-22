public class SaveLoad { // or whatever its called
  private GUI gui;  // give it a GUI variable 

  public SaveLoad(GUI gui) {
    this.gui = gui;  load in the current GUI into save load
    // ... other code ...
  }

  public void load() {
    // get the colors
    gui.loadColors(...); // method called on the visualized GUI.