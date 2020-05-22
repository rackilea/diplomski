int count=0;
String currentDay="Monday";
String nextDay;


// your while loop start here

count++;

if(count%6 == 0)
{
    switch(currentDay)
    {
    case "Monday": nextDay="Tuesday"; break;
    //etc
    }
currentDay = nextDay;
}