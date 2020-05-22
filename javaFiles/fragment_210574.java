for(int i=0;i<b.length-1;i++)
{
    b[i] = new Brick();//call appropriate c'tor what is defined by you.
    b[i].leftx=brick.weidth*(i%7);
    b[i].topy=brick.height*(i/7);
    b[i].height=brick.height;
    b[i].weidth=brick.weidth;
}