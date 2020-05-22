public void paintComponent(Graphics g){
    super.paintComponent(g); // this is super important
    if (paintImages){ // you need to define and set this flag
        g.drawImage(wallpaper,0,0,this);
        g.drawImage(title_text,0,0,this);
    }
}