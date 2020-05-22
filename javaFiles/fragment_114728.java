public Bullet(double mx, double my, double px, double py){
    if(x==640 && y== 320){
    sx = mx-px;
    sy = py-my;
    x = px;
    y = py;
    sx = sx/Math.sqrt((mx-x)*(mx-x) + (my-y)*(my-y));
    sy = sy/Math.sqrt((mx-x)*(mx-x) + (my-y)*(my-y));

}
    if(x!=640 && y!= 320){
    sx = px-mx;
    sy = my-py;
    x = px;
    y = py;
    sx = sx/Math.sqrt((mx-x)*(mx-x) + (my-y)*(my-y));
    sy = sy/Math.sqrt((mx-x)*(mx-x) + (my-y)*(my-y));

}

}