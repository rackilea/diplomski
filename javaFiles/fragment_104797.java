public boolean sameStepShape(int[] a, int[] b) {
boolean sameStep = false;

for (int i = 0; i < a.length - 1; i++) {
    if((a[i] < a[i+1]) && (b[i] >= b[i+1])){
        return sameStep;
    }
    else if((a[i] > a[i+1]) && (b[i] <= b[i+1])) {
        return sameStep;
    }
    else if((a[i] == a[i+1] && b[i] != b[i+1])) {
        return sameStep;
    }        
} 
return sameStep = true;
}