CustomPanel cp=...;//this class extends jpanel


for(int i=0;i<cp.getComponentCount();i++) {
    Component c=cp.getComponentAt(i);
     if( c instanceof JButton) {
         //do something
    }
 }