public static void main(String[] args) throws IOException{

            AppGameContainer appgc;
            try{
                    appgc = new AppGameContainer(new Blop(NAME));

                    //Window size
                    appgc.setDisplayMode(960, 640, false);
                    appgc.setShowFPS(false);
                    appgc.setAlwaysRender(true);
                    appgc.setTargetFrameRate(60);
                    appgc.setVSync(true);
                    Display.setIcon(new ByteBuffer[] {
                new ImageIOImageData().imageToByteBuffer(ImageIO.read(new File("res/images/general/Icon16.png")), false, false, null),
                new ImageIOImageData().imageToByteBuffer(ImageIO.read(new File("res/images/general/Icon32.png")), false, false, null)
                });

//TODO: Read in high scores file and populate Highscores class

                    appgc.start();
            }catch(SlickException e){
                    e.printStackTrace();
            }