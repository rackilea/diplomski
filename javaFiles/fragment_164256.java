images.addItemListener(  
new ItemListener() {  
public void itemStateChanged( ItemEvent e ) {  
Icon ico=new ImageIcon(toString(images.getSelectedItem()));
label.setIcon(ico);  
}  
}  
);