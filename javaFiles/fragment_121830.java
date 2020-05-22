int size = arr.length;
    System.out.print("[");
    for(int i=0;i< size; i++){
        System.out.print(arr[i]);
        if(i<size-1){
            System.out.print(",");
        }
    }
    System.out.println("]");
}