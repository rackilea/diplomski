//declare the filds outside any method
private double x1;
private double x2;
private double y1;
private double y2;

MyRectangle2D(){
   //... Your normal code here
   buildWeird();
}
MyRectangle2D(double X, double Y, double Width, double Height){
    //... Your normal code here
    buildWeird();
}
private void buildWeird(){
    this.x1 = x-(width/2);
    this.x2 = (x+(width/2));
    this.y1 = (y-(height/2));
    this.y2 = (y+(height/2));
}