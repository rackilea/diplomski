void DoCalcs () {
    for (int i = 1; i <= 10; i++) {
        int result = Y (i);
    }
}


int Y (int i) {
    //calculate start index for x
    int xIndex = Math.Max (1, i - 4);

    //calculate end index for x
    int endXIndex = Math.Min (6, i);

    //running sum
    int totalresult = 0;

    //loop through h until reaches zero, or until we run out terms in the sum
    for (int startHIndex = Math.Min (5, i); startHIndex >= 1; startHIndex--) {
        totalresult += X (xIndex) * H (startHIndex);
        xIndex++;

        //if we run out of terms, break out and return result
        if (xIndex > endXIndex) {
            return totalresult;
        }

    }
    //otherwise return error
    return -9999;
}


int X (int i) {
    return i + 1;
    //this could be whatever
}

int H (int i) {
    return i + 2;
    //this could be whatever
}