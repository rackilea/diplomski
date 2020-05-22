public static double globalDelta;

while(nextFrame) //Loops once per frame
{
    updateGame();

    globalDelta = calculateDelta();
}