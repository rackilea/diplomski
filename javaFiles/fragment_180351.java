int max = 0;
int val = -1;
for (int i = 0 ; i != 10 ; i++) {
    if (counts[i] > max) {
         max = counts[i];
         val = i;
    }
}

// If you did not see any number because the array was empty, val remains -1.
System.out.println(val);