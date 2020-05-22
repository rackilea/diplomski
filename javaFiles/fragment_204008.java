PImage images;
...
...
...

void draw(){
  if(mousePressed){
    images = loadImage(folder+"/"+imageNames[0]);
    println(images);
    println(imageNames[i]);
    delay(200);
    i++;
  }
  image(images,0,0);      //NULL POINTER EXCEPTION!
}