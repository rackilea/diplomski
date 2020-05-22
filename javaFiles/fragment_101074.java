for(int w = 1; w <= a.length; w++){ 
    System.out.println("Window size : " + w);
    for(int i = 0; i < a.length - w + 1; i++){
        for(int j = i; j < i + w; j++){
                System.out.print(a[j]);
        }
        System.out.println();
    }
}