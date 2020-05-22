int boundary1 = 10;
int boundary2 = 30;
int boundary3 = 70;
int myIndex = 0;

for (i = 0; i < 100; i++)
{
    //do something with myIndex.
    myIndex++;

    if (i == boundary1 || i == boundary2 || i == boundary3)
    {
        myIndex = 0;
    }
}