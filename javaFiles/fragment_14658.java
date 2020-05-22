public void getCamera() {


    camera = camera.open();
    params = camera.getParameters();
    camera.startPreview();

}
public void turnOnFlash() {
    if(camera != null){
     params = camera.getParameters();
     params.setFlashMode(Parameters.FLASH_MODE_TORCH);
     camera.setParameters(params);
     camera.startPreview();
    }else{
    Log.e("CHECK","Camera null");
    }

}