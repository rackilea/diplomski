if (myRs.next()) {  // <-- Advances to the next row
    while (k < i) { // <-- What is this loop supposed to do?

    }
    myRs.next();    // <-- Advances to the next row, but that
                    //     row is never used. Delete this line.
    k++;
}