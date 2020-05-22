for (int i = 0; i < objects.size(); i++) {
    if(this.bounds.getRCol().intersects(objects.get(i).bounds.getLCol())){
       collision = true;
       setVelX(0);
    }else{collision = false;}
}