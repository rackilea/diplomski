void mousePressed(){
    int tile_width  = width / n_partition;  // adapt this for your needs 
    int tile_height = height / n_partition;

    int x = round(mouseX / (float)tile_width) * tile_width;
    int y = round(mouseY / (float)tile_height) * tile_height;
    position[BallNum]= new PVector(x, y);
    BallNum++;
}