private Image getCroppedImage(String address) throws IOException{
    BufferedImage source = ImageIO.read(new File(address)) ;

    boolean flag = false ;
    int upperBorder = -1 ; 
    do{
        upperBorder ++ ;
        for (int c1 =0 ; c1 < source.getWidth() ; c1++){
            if(source.getRGB(c1, upperBorder) != Color.white.getRGB() ){
                flag = true;
                break ;
            }
        }

        if (upperBorder >= source.getHeight())
            flag = true ;
    }while(!flag) ;

    BufferedImage destination = new BufferedImage(source.getWidth(), source.getHeight() - upperBorder, BufferedImage.TYPE_INT_ARGB) ;
    destination.getGraphics().drawImage(source, 0, upperBorder*-1, null) ;

    return destination ;
}