myChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
myChooser.addPropertyChangeListener(new PropertyChangeListener() {
public void propertyChange(PropertyChangeEvent evt) {
    if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(evt.getPropertyName())) {
           File file = (File) evt.getNewValue();

           if (file != null && file.isFile()) { 
                setOpenButtonState(myChooser, false);

           }
           else if ( file != null ) {
                setOpenButtonState(myChooser, true);
                System.out.println(file.getName());
           }
        }

        myChooser.repaint();
    }
});

public static void setOpenButtonState(Container c, boolean flag) {
    int len = c.getComponentCount();
    for (int i = 0; i < len; i++) {
      Component comp = c.getComponent(i);

      if (comp instanceof JButton) {
        JButton b = (JButton) comp;

        if ( "Open".equals(b.getText()) ) {
            b.setEnabled(flag);
        }

      } else if (comp instanceof Container) {
          setOpenButtonState((Container) comp, flag);
      }
    }     
}