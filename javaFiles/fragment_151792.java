@Override 
public void mousePressed(MouseEvent e){

    //To get the image which is selected:
    for(MyImage img : myList)
        if(img.isSelected(e.getX(), e.getY())){  //if mouse clicks on this image
            selectedImage = img;    
            break;
        }
}

@Override
public void mouseDragged(MouseEvent e){
    if(selectedImage != null){
        selectedImage .setLocation(e.getX()-(pieceWH/2), e.getY()-(pieceWH/2));
        repaint();
    }
}