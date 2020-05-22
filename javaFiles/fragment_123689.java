// no check
        for (int i=0; i < ARRAY_LENGTH; i++) {
            target[i] = source[i];
        }

        // check, then set if unequal
        for (int i=0; i < ARRAY_LENGTH; i++) {
            int x = source[i];
            if (target[i] != x) {
                target[i] = x;
            }
        }