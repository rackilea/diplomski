package com.search.demo;

public class FibonacciSearch {

int a[] = {10,20,30,40,50,60,70,80,90,100};
static FibonacciSearch fs;

/**
 * @param args
 */
public static void main(String[] args) {
    // TODO Auto-generated method stub
    fs = new FibonacciSearch();
    int location = fs.find(70);
    if(location < 0){
        System.out.println("number not found..");
    }else{
        System.out.println("found at location "+location);
    }
}

private int find(int no){
    int n = a.length;
    int m = findFm(n);                  //m = Fm iff n is Fibonacci number else returns Fm+1
    int p = fibSequenceIterative(m-1);  //p = Fm-1, always a fibonacci number
    int q = fibSequenceIterative(m -2); //q = Fm-2, always a fibonacci number

    while(true){
        if(no == a[m]){
            return m;
        }else if (no < a[m]){
            if(q == 0){
                return -(m - 1);// we crossed 0th index in array, number not found.
            }                   
            m = m - q;  //moved to 1 step left towards a fibonacci num
            int tmp = p;//hold this temporarily
            p = q;      //move p to 1 step left into another fibonacci num
            q = tmp - q;//moved q to 1 step left....
        }else if(no > a[m]){
            if(p == 1){
                return -m;//we reached 0th index in array again and number not found..
            }
            m = m + q;
            p = p - q;
            q = q - p;
        }
    }

}

private int findFm(int n){
    int prev = 1;
    int curr = 1;
    int next = 0;

    if(n == 0){
        next = 0;
        return -1;
    }else if(n == 1 || n == 2){
        next = 1;
        return 1;
    }else{
        for(int i = 3; ; i++){
            next = prev + curr;
            prev = curr;
            curr = next;
            System.out.println("prev = "+prev+" curr = "+curr+" next = "+next);
            if(n <= curr){
                System.out.println("n = "+n+" curr = "+curr);
                return i;
            }
        }
        //return -1;//we should not get here..
    }


}

/* Iterative method for printing Fibonacci sequence..*/
private int fibSequenceIterative(int n){
    int prev = 1;
    int curr = 1;
    int next = 0;

    if(n == 0){
        next = 0;
        //return 0;
    }else if(n == 1 || n == 2){
        next = 1;
        //return 1;
    }else{
        for(int i = 3; i <= n; i++){
            next = prev + curr;
            prev = curr;
            curr = next;
        }
        return next;
    }
    return next;
}


}