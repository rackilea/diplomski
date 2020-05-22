nextCandidate:
do{
    numb += 2;
    int numbSqrt = (int)java.lang.Math.sqrt(numb);

    for (int i = 3; i <= numbSqrt; i = i+2)
    {
        if (numb % i == 0)
        {
            continue nextCandidate;
        }
    }
    break;

}while(true);