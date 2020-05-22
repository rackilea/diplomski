for (int x: a) {
    int count = 0;
    for (int y: a) {
        if (x == y) {
            count++;
            if (count > a.length/2) {
                return true;
            }
         }
    }
}
return false;