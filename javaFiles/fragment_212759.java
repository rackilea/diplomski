public Screen findRegion(){
    Screen screen = null;
    try{
        screen = new Screen();
        int x = screen.find("C:\\Users\\skhan\\Desktop\\Images\\VVX500\\Capture2.PNG").getX() - 10; 
        int y = screen.find("C:\\Users\\skhan\\Desktop\\Images\\VVX500\\Capture2.PNG").getY() - 10; 
        int w = x + 370;
        int h = y + 300;
        screen.setRect(x,y,w,h);

    }
    catch(FindFailed e){
        e.printStackTrace();
    }
    return screen;

}