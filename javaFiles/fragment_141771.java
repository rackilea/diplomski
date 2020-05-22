String ans = "out";
    int index = n;
    while (index > 0) {
        index = inn[index];
        ans = "" + index + ", " + ans;
    }
    System.out.println(ans);