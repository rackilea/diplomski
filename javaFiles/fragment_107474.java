if (m == 1 || m == 2)
        hare += 9;
    else if (m == 6)
        hare -= 12;
    else if (m == 3 && m == 5) //there is something wrong here, m cant be 5 and 3 ;)
        ++hare;
    else if (m == 7 || m == 8)
        hare -= 2;
    else if (m == 9 || m == 10)
        hare += 0;