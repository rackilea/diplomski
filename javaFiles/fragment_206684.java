int o=getStatus();
       if(o==1 && tab.getSelectedIndex() != 0) //if the selected index isn't 0 and the o == 1
       {
            tab.setSelectedIndex(0);
            JOptionPane.showMessageDialog(null, "Tabbed 1 Progress!!!", "Confirmation!!!",JOptionPane.ERROR_MESSAGE);
            //setStatus(0); delete this
            //setStatus(1); delete this
       }