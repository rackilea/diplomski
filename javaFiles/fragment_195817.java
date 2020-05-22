int count = 0;
double total = 0;

// For each array in a
for(double[] array : a) {
    // For each value in array
    for(double val : array) {
        total += val;
        count++;
    }
}

double average = total / count;