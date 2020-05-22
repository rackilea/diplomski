for (numberDividing = 2; (numberDividing < divider) && (divider % numberDividing != 0); numberDividing++) {
    }

    if (numberDividing >= divider) {
        arrayPrime[x] = divider;
        x++;
    }