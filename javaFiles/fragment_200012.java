protected void paintComponent(Graphics g){
    super.paintComponent(g);
        drawString(g, 5, 10);
        if(klickad==false)
            klickadVal(g, 0, 0);

        else if(klickad==true)
            oKlickadVal(g);
}