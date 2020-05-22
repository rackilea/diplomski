label1:
    for (; ; ) {
        label2:
        for (; ; ) {
            if (condition1) {
                // break outer loop
                break label1;
            }
            if (condition2) {
                // break inner loop
                break label2;
            }
            if (condition3) {
                // break inner loop
                break;
            }
        }
    }