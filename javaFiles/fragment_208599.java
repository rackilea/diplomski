public boolean member(point P) {
    // search for P in p
    for (int i = 0; i < p.length; i++) {
        // if it is contained
        if (p[i].equals(P)) {
            // here it is
            return true;
        }
    }

    // couldn't find P
    return false;
}

public boolean subset(Set S) {
    // check for every point in p
    for (int i = 0; i < p.length; i++) {
        // whether it is contained in S
        if (!S.member(p[i])) {
            // can't be a true subset
            return false;
        }
    }

    // everything is as expected
    return true;
}