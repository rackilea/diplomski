float x, y; 
float steps = 20.0;

void setup(){
    size(800,300);
    background(#C8F5F2);
    frameRate(10);

    x = 0.4*height/8;
    y = 0.4*width/8;
}

void draw(){

    float radius1 = 0.4*height/8; 
    float radius2 = 0.4*width/8; 

    fill(255);
    noStroke();
    rectMode(CENTER);
    rect(width/2, 0, width/8, height*2);  //vertical lane 
    rect(0, height/2, 2*width, height/8); //horizontal lane 

    fill(255,0,0,100);
    ellipse(x, height/2, radius1*2.0, radius1*2.0); //vertical ellipse

    fill(0,255,0,100);
    ellipse(width/2, y, radius2*2.0, radius2*2.0); //horizontal 

    if(x < width - radius1){
        x += (width - 2.0*radius1) / steps;
    }
    if(y < height - radius2){
        y += (height - 2.0*radius2) / steps;
    }
}