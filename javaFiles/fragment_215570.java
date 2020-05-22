outer: while (condition1) {
//  ^^^^^----- the label
        while (condition2) {
            if (condition3) {
                break outer;
// Directed ----------^^^^^
            }
        }
    }