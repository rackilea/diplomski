public int [] method (int a) {
    int [] newarray = new int[count];

    for (int i = 1; i <= a; i++)  {
        if (a % i == 0) {
            for (int m = 0; m < count; m++) {        
                if (newarray[m] == 0) {
                   newarray[m] = a/i;
                   break;
                }
            }

            break;//Depending on your wanted solution
        }
    }

    return newarray;
}