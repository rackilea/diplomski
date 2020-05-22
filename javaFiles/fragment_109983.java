private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {                                      
    int value = jSlider1.getValue(); 

    if(value==55) {
        ImageIcon myImage = (ImageIcon) label.getIcon();
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth()+10, label.getHeight()+10,Image.SCALE_SMOOTH);
        label.setIcon( new ImageIcon(newImg) );
    }
}