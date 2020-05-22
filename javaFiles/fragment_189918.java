boolean collides=false;
    for(int i = 0; i < g.getBounds().size; i++) {
        Intersector.intersectRectangles(bounds, g.getBounds().get(i), intersection);
        if((bounds.overlaps(g.getBounds().get(i))) && intersection.y > g.getBounds().get(i).y) {
            collides=true;
        }
    }

    if(collides){
        vel.y = 0;
        if (MyInput.isPressed(MyInput.SPACE)) {
              vel.y = 5;
        }
    }else{
        vel.y-=.0005f;
    }