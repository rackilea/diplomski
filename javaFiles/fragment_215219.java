private ItemListener setIconHandler = new ItemListener() {
    public void itemStateChanged (ItemEvent e)  {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            picture.setIcon(pics[box.getSelectedIndex()]);

        }//end if 

    }//end itemstatechanged 
};