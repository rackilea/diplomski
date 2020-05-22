splitPane.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, new SplitPanePropertyChangeListener());

private class SplitPanePropertyChangeListener implements PropertyChangeListener {    
    public void propertyChange(java.beans.PropertyChangeEvent evt) {    
        int nv = ((Integer) evt.getNewValue()).intValue();    
         if (nv == 1) { //adjust this depending on your divider location    
         setSize(new Dimension(800, 560));    
      }    
      if (nv == 221) { //adjust this depending on your divider location    
         setSize(new Dimension(1000, 560));    
      }     
   }    
}