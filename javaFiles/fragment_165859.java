public void setup() {

    size(800,600);
}

boolean down = false;
float R = 255;
float G = 255;
float B = 0;
float incrementoR = +1;
float incrementoG = +1;
float incrementoB = +1;
float mincol = 0, maxcol = 255;

public void draw() {

    background (1,255,1);

    if(down) {

        println("\nFramecount: "+frameCount);
        println("The current framerate is: "+frameRate);
        background(R,G,B);
        R += incrementoR;
        if (R > maxcol) incrementoR = -1;
        else if (R > mincol) incrementoR = random(2);
            B += incrementoB;
        if (B > maxcol) incrementoG = -1;
        else if (B < mincol) incrementoG = +5;
            G += incrementoG;
        if (G > maxcol) incrementoB = -1;
        else if (G < mincol) incrementoB = +10;
        frameRate(150);
        }

     fill(127);   
     text("R:"+(int)R+"\tG:"+(int)G+"\tB:"+(int)B,15,15);

    }


public void mousePressed() {
    down = true;
}