count = 0
for (int x: a) {
    if (count == 0) {
        candidate = x;
    }
    if (x == candidate) {
        count += 1
    } else {
        count -= 1
    }
}
count = 0;
for (int x: a) if (a==candidate) count++;
return count > a.length / 2;