if(Intersector.overlaps(circle, rectangle)){
    tmp.set(rectangle.x, rectangle.y + rectangle.height/2, rectangle.width, rectangle.height/2);
    if (Intersector.overlaps(circle, tmp){
        //top half (or both top and bottom) hit
    } else {
        //bottom half hit
    }
}