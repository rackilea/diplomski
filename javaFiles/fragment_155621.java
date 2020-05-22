public static void main(String[] args) {

    int[] arr={9,1,7,13,3};
    int i = 0;
    int res = SubsetSum(arr, 21, 0, 0);
    while (res > 0) {
        if ((res & 1) > 0) 
            System.out.println(i);
        i++;
        res >>= 1;
    }       
}   

public static int SubsetSum(int[] arr, int sum, int index, int used){
    if(sum==0)
        return used;
    if(sum<0 | index>=arr.length)
        return 0;
       int a = SubsetSum(arr,sum,index+1, used);
       int b = SubsetSum(arr,sum-arr[index],index+1, used | (1 << index));
       if (a > 0)
          return a;
       else
          return b;
}  
}