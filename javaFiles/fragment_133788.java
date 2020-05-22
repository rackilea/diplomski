public double alternatingSum() {
    double alternatingSum = 0;
    if(data != null || dataSize > 0) {
        for(int i = 0; i < dataSize; i = i + 2) {
            alternatingSum += data[i];
        }
        for(int i = 1; i < dataSize; i = i + 2) {
            alternatingSum -= data[i];
        }
    }
    return alternatingSum;
}