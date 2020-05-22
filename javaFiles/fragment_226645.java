class MyImage{
    private BufferedImage img;
    private int imgWidth;
    private int imgHeight;

    public MyImage(String imagePath){       
        try{
            img = ImageIO.read(getClass().getResource(imagePath));
        }catch(IOException ioe){System.out.println("Unable to open file");}
        init();
    }

    public MyImage(BufferedImage img){
        this.img = img;
        init();
    }

    private void init(){
        imgWidth = img.getWidth;
        imgHeight = img.getHeight();
    }

    public boolean equals(BufferedImage img){
        //Your algorithm for image comparison (See below desc for your choices)
    }

    public boolean contains(BufferedImage subImage){
        int subWidth = subImage.getWidth();
        int subHeight = subImage.getHeight();
        if(subWidth > imgWidth || subHeight > imgHeight)
            throw new IllegalArgumentException("SubImage is larger than main image");

        for(int x=0; x<(imgHeight-subHeight); x++)
            for(int y=0; y<(imgWidth-subWidth); y++){
                BufferedImage cmpImage = img.getSumbimage(x, y, subWidth, subHeight);
                if(subImage.equals(cmpImage))
                    return true;
            }
        return false;
    }
}