public int tortoiseMoves() {
    int i = tGen();
    if (i >= 1 && i <= 5)
    {
        int fastplod = 3;
        return fastplod;
    }

    else if (i >= 6 && i <= 8)
    {
        int slowplod = 1;
        return slowplod;
    }

    else if (i >= 9 && i <= 10)
    {
        int slip = -6;
        return slip;
    }
    else {
        // return something or throw exception
        return 0;
    }
}