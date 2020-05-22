ME img;

void setup(){
   size(500 ,500);
   img = new ME("image.png");
   img.display(width , height);
   img.effect(30);
}

void draw(){
    img.effect(30);
    img.display(width, height);
}