for(int i = buckets.length - 1; i >= 0; i--) {
    System.out.print("%2d-%3d | ", i * 10 + 1, i * 10 + 10);
    for(int j = 0; j < buckets[i]; j++){
        System.out.print("[]");
    } 
    System.out.println("");
}