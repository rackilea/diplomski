@Override  
public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {  
  painter = () -> {  
      doSomething(width, height, width, height, gl);
  };  
  handler.post(painter);  
}