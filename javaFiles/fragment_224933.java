if((n-5*j)%3 == 0) // if so, then j is a solution: b=n-5*j and a=5*j

    for(int k = 0;k< n-5*j;k++)
        answer.append("5"); // print 5 b times
    for(int k = 0;k < 5*j;k++)
        answer.append("3"); // print 3 a times