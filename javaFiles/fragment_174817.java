Double prev = null;

// inside loop:

double curr = getMethodResult(...);

if (prev != null) {
    double avg = (curr + prev) / 2;
}

prev = curr;

// end of loop