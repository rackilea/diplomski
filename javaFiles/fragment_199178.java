for (int i = 0; i < tmp.length(); i++) {
    if (tmp.charAt(i) == '|') {
        count = count + 1;
        System.out.println(i);
        if (count == 1) {
            start = i;
        } else if (count == 2) {
            start1 = i;
        } else if (count == 3) {
            start2 = i;
        } else if (count == 4) {
            start3 = i;
        } else if (count == 5) {
            start4 = i;
        }
    }
}