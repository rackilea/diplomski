int low = 0;
int high = a.length-1;
while (low < high) {
    int mid = (low + high) / 2;
    int cmp = comp.compare(a[mid], key);
    if (cmp < 0)
        low = mid + 1;
    else
        high = mid;
}
if (comp.compare(a[low], key) == 0)
    return low;
else 
    return -1;