// ship position
float posx, posy;
// ship velocity
float vx,vy;
// gravity
float gravity;
// user input
boolean moveLeft, moveRight, moveUp;
// time
float timelast = 0, timenow, timeelapsed;

void setup() {

    size(500, 500);
    background(0);

    //inital position
    posx = 225;//int(random(width - 50)); //position of the left vertex of our ship
    posy = 200; // position of the bottom vertex of our ship
    // initial user input
    moveLeft = moveRight = moveUp= false;
    // initial velocity
    vx = vy = 10;
    // gravity
    gravity = 10;
    timelast = millis();
}

void draw() {

    noStroke();
    background(0);

    fill(255,255,255);
    rect(0,470,width,30);
    fill(255,0,0);
    rect(200,470,100,30);

    updateTime();
    userInput();
    moveShip();
    drawShip();
}

void updateTime() {

    timelast = timenow;
    timenow = millis();
    timeelapsed = timenow - timelast;
}

void drawShip() {

    fill(169,169,169);
    rect(posx,posy,50,25);

    fill(255,255,255);
    rect(posx+20,posy-10,10,10);

    fill(105,105,105);
    rect(posx+20,posy+25,10,5);

    stroke(255,255,255);
    strokeWeight(2);
    line(posx+2,posy+25,posx+2, posy+40);

    stroke(255,255,255);
    strokeWeight(2);
    line(posx+48,posy+25,posx+48, posy+40);
}

void userInput() {

    if (moveLeft)
        vx -= 100 * timeelapsed / 1000;
    if (moveRight)
        vx += 100 * timeelapsed / 1000;
    if (moveUp)
        vy -= 100 * timeelapsed / 1000;
}

void moveShip() {

    vy += gravity * timeelapsed / 1000;

    posx += vx * timeelapsed / 1000;
    posy += vy * timeelapsed / 1000;

    // Detecting collisions
    if (posx + 50 >= width || posx <= 0)
        vx *= -1;
    if (posy - 25 <= 0)
        vy *= -1;
    if (posy + 50 >= height) 
        vx=vy=0;
}

void keyPressed() {

    if (key==CODED) {
        switch (keyCode) {
            case UP:
                moveUp = true;
                break;
            case LEFT:
                moveLeft = true;
                break;
            case RIGHT:
                moveRight = true;
                break;    
        }
    }  
}

void keyReleased() {

    if (key==CODED) {
        switch (keyCode) {
            case UP:
                moveUp = false;
                break;
            case LEFT:
                moveLeft = false;
                break;
            case RIGHT:
                moveRight = false;
                break;    
        }
    }  
}