int height = 100; //the height of the rectangle
int width = 200; //the width of the rectangle
for(int i = 0; i < 2; i++) //repeat the following twice
{
    tParam.forward(height); //go forward the height of the rectangle
    tParam.turn(90); //turn 90 degrees
    tParam.forward(width); //go forward the width of the rectangle
    tParam.turn(90); //turn 90 degrees
} //end loop