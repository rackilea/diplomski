Rectangle self_shape=this.getBounds();
Rectangle other_shape=actor.getBounds();
bool collision = self_shape.intersects(other_shape);
if(collision){
    //create two new variables self_centerx and self_centery
    //and two new variables other_centerx and other_centery
    //let them point to the coordinates of the center of the
    //corresponding rectangle

    bool left=self_centerx - other_centerx<0
    bool up=self_centery - other_centery<0
}