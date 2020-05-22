class UIPanel {
    UIPanel(Model m) {
         m.addActionListener(listener);
    }
}

class MainPanel {
    ...
    MainPanel() {
        ...
        UIPanel uiPanel = new UIPanel(m); // Constructor, a separate setter would be possible also
        ...
     }
}