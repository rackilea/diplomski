for(int i = 0; i < n; i++) {
    for(int j = i+1; j < n; j++) {
        if(arr_sort[j] < arr_sort[i]) {
            temp = arr_sort[i];
            arr_sort[i] = arr_sort[j];
            arr_sort[j] = temp;
        }
    } 
}