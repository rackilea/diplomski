public void buildWalls(){

    wall.setFill(new ImagePattern(wallImage));
    for(int i = 0;i<walls.length;i++){
        for(int j = 0;j<walls[i].length;j++){
            if(walls[i][j]==1){
                wall = new Rectangle(wallImage.getWidth(), wallImage.getHeight());
                wall.setX(j*20);
                wall.setY(i*20);

                borderPane.getChildren().add(wall);
            }
        }
    }
}