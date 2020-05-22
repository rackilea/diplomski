int low = 0;
int high = size-1; // high = 1
int middle = -1;
boolean found = false;
while (!found && low < high) {
    middle = low + (high-low)/2; // middle = 0 + (1-0) / 2 = 0
    if (a[middle] == val) // FALSE (because a[0] = 0)
       found = true;
    else if (a[middle] < val) // TRUE (because a[0] = 0 and 0 < 1)
       low = middle + 1;  // low = 0 + 1 = 1
    else // (a[middle] > val)
       high = middle - 1;
}
return found;