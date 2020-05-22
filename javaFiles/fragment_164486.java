int arr[] = new int[2];

if(array.length==0){
    arr[0] = array2[0];
    arr[1] = array2[1];     
}
else if(array.length==1){
    arr[0] = array[0];
    arr[1] = array2[1];
}
else if(array.length==2){
    arr[0] = array[0];
    arr[1] = array[1];
}
else{
    System.out.println("no");
}

System.out.println(arr[0]);
System.out.println(arr[1]);