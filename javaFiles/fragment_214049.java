int start = -1;
int end = vec.length;
int i = 0;
int j = vec.length-1;
while (i < j) {
    if (vec[i] == 1 && start < 0)
        start = i;
    i++;
    if (vec[j] == 1 && end >= vec.length)
        end = j;
    j--;
    if (start >= 0 && end < vec.length)
        break;
} 
int count = 0;
if (start >= 0 && end < vec.length) {
    for (i = start + 1; i < end; i++) {
        if (vec[i] == 0)
            count++;
    }
}