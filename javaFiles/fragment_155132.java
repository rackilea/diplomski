int count = 0;

    for(int i: in) {
        if (i==v) {
            count++;
        }
    }

    int[] result = new int[in.length-count];
    int pos=0;
    for(int i: in) {
        if (i!=v) {
            result[pos] = i;
            pos++;
        }
    }