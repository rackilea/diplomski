Component[] comps = parent.getComponents();
for(Component c:comps){
    if(c instanceof JButton){
        JButton btn = (JButton) c;
        String text = btn.getText();
        //Use text for whatever, add it to an array or something
    }
}