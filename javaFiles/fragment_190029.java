//public static Color r; //Should not be static, all DropObjects will have the same color
private Color r;

public DropObject(int yukseklik,int x,int y,int size,Color r){   

  this.r =EventRect.RColor();
  block=control();
  this.yukseklik=yukseklik-block;
  this.object=new Rectangle(x,y,size,size);


  public Color getColor(){
    return this.r;
  }