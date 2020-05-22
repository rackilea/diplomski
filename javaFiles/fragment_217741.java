protected void setCartesian(){//set xyz to a standard plane
    yrotrad = (float) (yrot / 180 * Math.PI);
    xrotrad = (float) (xrot / 180 * Math.PI);
    float pd = (float) (Math.PI/180);
    x = (float) (-Math.cos(xrot*pd)*Math.sin(yrot*pd));
    z = (float) (-Math.cos(xrot*pd)*Math.cos(yrot*pd));
    //y = (float) Math.sin(xrot*pd);
}//..

public void forward(){// move forward from position in direction of camera
    setCartesian();
    x += (Math.sin(yrotrad))*spd;
    z -= (Math.cos(yrotrad))*spd;
    //y -= (Math.sin(xrotrad))*spd;
    body.applyForce(new Vector3f(x,0,z),getThrow());
}//..


public Vector3f getThrow(){// get relative position of the camera

    float nx=x,ny=y,nz=z;
    float xrotrad, yrotrad;
    yrotrad = (float) (yrot / 180 * Math.PI);
    xrotrad = (float) (xrot / 180 * Math.PI);
    nx += (Math.sin(yrotrad))*2;
    nz -= (Math.cos(yrotrad))*2;
    ny -= (Math.sin(xrotrad))*2;
    return new Vector3f(nx,ny,nz);
}//..