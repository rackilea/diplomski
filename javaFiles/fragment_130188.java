int p1score = roll(p1, 0, fin);

    int p2score = roll(p2, 0, fin);

    while (p1score < fin && p2score < fin ) {

        p1score += roll(p1, 0, fin);

        p2score += roll(p2, 0, fin);

    }