public void paint(Graphics g){
    while(running){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.drawImage(image,0,0,width,height, null);
        g.dispose();
        bs.show();
    }
}