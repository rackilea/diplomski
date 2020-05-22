public static Camera checkForCamera(){
    Camera camera = null;
    try {
        camera = Camera.open(); // this line will throw exception if camera is not in use.
    }
    catch (Exception e){
        // if exception is thrown, return your boolean value here...
    }
    return camera; // if instance of camera, if it is not available it will return null.
}