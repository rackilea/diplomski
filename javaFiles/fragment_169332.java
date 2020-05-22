public class Phone {
    private Camera camera;
    private Features features;

    public Phone(Camera camera, Features features){
        this.camera = camera;
        this.features = features;
    }

    public void setCamera(Camera newCamera){
        this.camera = newCamera;
    }

    public void setFeatures(Features newFeatures){
        this.features = newFeatures;
    }

    public Camera getCamera(){
        return camera;
    }

    public Features getFeatures(){
        return features;
    }

}