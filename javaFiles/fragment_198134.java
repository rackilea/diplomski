int max = INT_MIN;
int maxdiff = 0;

for (i = sizeof(arr) / sizeof(int) - 1; i >= 0; i--) {
  if (max < arr[i]) {
    max = arr[i];
  }
  int diff = max - arr[i];
  if (maxdiff < diff) {
    maxdiff = diff;
  }
}

print maxdiff;