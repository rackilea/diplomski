public void render(Graphics g){
for(int i = 0; i < object.size(); i++){
    GameObject tempObject = object.get(i);
    tempObject.tick();
    tempObject.render(g);
}
}