@Override  
public void surfaceChanged(SurfaceHolder holder, int format, final int width, final int height) {  
  painter = new Runnable() {  
    @Override  
    public void run() {  
      doSomething(width, height, width, height, gl); 
    }  
  };  
  handler.post(painter);  
}