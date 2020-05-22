if(display.getRotation() == Surface.ROTATION_0){//0
    parameters.setRotation(90);
    mCamera.setDisplayOrientation(90);
}else if(display.getRotation() == Surface.ROTATION_90){//1
    parameters.setRotation(0);
    mCamera.setDisplayOrientation(0);
}else if(display.getRotation() == Surface.ROTATION_180){//2
    parameters.setRotation(270);
    mCamera.setDisplayOrientation(270);
}else if(display.getRotation() == Surface.ROTATION_270){//3
    parameters.setRotation(180);
    mCamera.setDisplayOrientation(180);
}