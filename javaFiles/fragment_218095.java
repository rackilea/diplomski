for (int m = 0; m < Bag.length; m++) {   
    boolean Seen = false;
    for (int n = 0 ; n < m - 1 ; n++) {
        if (Bag[m] == Bag[n]) {
            Seen = true;
            break;
        }
    }
    if (Seen) {
      continue;
    }

    int occurrence = 0;
    for (int n = 0 ; n < Bag.length ; n++) {
        if (Bag[m] == Bag[n]) {
            occurrence++;
        }
    }

    if (occurrence > 1) {
        System.out.println(Bag[m] + " occurs " + occurrence + " times");
    } else {
        System.out.println(Bag[m] + " occurs " + occurrence + " time");
    }
}