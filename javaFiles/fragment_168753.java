int change = arr[1] - arr[0]; //give it an initial value, if we find a bigger change we will replace it
for(int i = 0; i < arr.length - 1; i++) {
    for(int j = i + 1; i < arr.length; j++) {
        if(arr[j]-arr[i] > change) {
            change = arr[j]-arr[i];
        }
    }
}