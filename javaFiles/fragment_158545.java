// Display the bricks that make up the game
// *[3]**********************************************************
// * Fill in code to display bricks (A brick may not exist)     *
// **************************************************************

for (GameObject brick : bricks) 
{
    if (null != brick)
    {
        display ( g, brick );
    }
}