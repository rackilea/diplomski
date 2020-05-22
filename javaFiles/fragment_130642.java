public static int timeLapsed(int perimeter1, int speed1, int perimeter2, int speed2) {
    int greater,smaller;
    int speed, result = 0;
    if(perimeter1 >  perimeter2)    {
        greater = perimeter1;
        smaller = perimeter2;
        speed = speed1;
    }   else    {
        greater = perimeter2;
        smaller = perimeter1;
        speed = speed2;
    }
    for(int i=1;i<=smaller;i++)     {
        if(((greater*i)%smaller)==0)    {
            result = greater*i;
            break;
        }
    }

    return result/speed-10;
}