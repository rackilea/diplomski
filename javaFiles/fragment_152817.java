public void draw(GraphicsContext g){
     //(javafx.scene.image.Image, 
     // sourceX,sourceY, sourceWidth,sourceHeight,
    //outputX,outputY,outputWidth,outputHeight);        
    g.drawImage(RESOURCE, 0, 0, RESOURCE.getWidth(), RESOURCE.getHeight(), RESOURCE.getWidth(),0,-RESOURCE.getWidth(),RESOURCE.getHeight());
}