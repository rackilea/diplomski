private class ImageObject{
     private String name;
     private int size; 
     private BufferedImage bitmap;

  public ImageObject(String name, int size, BufferedImage bitmap){
     this.name = name;
     this.size = size;
     this.bitmap = bitmap;
  }

  public String getName(){ 
     return name; 
  }

  public int getSize(){ 
     return size; 
  }

  public BufferedImage getBitmap(){ 
     return bitmap; 
  }

  public void setName(String name){ 
     this.name = name; 
  }

  public void setSize(int size){ 
     this.size = size; 
  }

  public void setBitmap(BufferedImage bitmap){ 
     this.bitmap = bitmap; 
  }
}