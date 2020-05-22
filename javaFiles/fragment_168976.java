if(parts.size()!=0)
    {
        for (int i = 0; i <parts.size(); i++){
        if(parts.get(i) instanceof Block){
       circles[i].setIndex(parts.get(i).getIndex()) ;

        circles[i].setPosition(circles[i].getX(), (frame.getY() - 
     (frame.getRadius() * 3)) - (60 * i));
}