if(e.getKeyChar() == KeyEvent.VK_ENTER){
            JComponent ja = (JComponent) e.getSource();
            JComboBox jcbloc = (JComboBox) ja.getParent();
            JTable jtb = (JTable) jcbloc.getParent();
            jtb.changeSelection(0,1,false,false);
        }