@Override         
public boolean touchDown(float x, float y, int pointer, int button) {
    Vector3 touchPoint = new Vector3(x, y, 0); //0 is arbitrary since this is in 2D
    camera.unproject(touchPoint); //now touchPoint contains the world position of the touch
    xpos = touchPoint.x;      
    ypos = touchPoint.y; //if you need it. 
    return false;       
}