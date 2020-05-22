Arrays.sort(a); // actually I hate this because it mutates your array (BAD!)
for (int i = 0; i < a.length; i++) {
    int count = 0;
    for (int j = i; i < j.length; j++) {
        if (a[j] == a[i]) {
            count++;
            if (count > a.length / 2) {
                return true;
            }
         } else if (a[j] > a[i]) {
             break; // no more to count
         }
    }
}
return false;