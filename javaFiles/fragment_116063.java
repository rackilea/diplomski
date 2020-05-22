public static int carAssemblyRec(int[][] a, int[][] t, int[] e, int[] x, int n, int line){  
    if(n == 0){  
        return e[line] + a[line][0];  
    }  

    int T0 = Integer.MAX_VALUE;  
    int T1 = Integer.MAX_VALUE;  
    if(line == 0){      
        T0 = Math.min(carAssemblyRec(a, t, e, x, n-1, 0) + a[0][n],             
                            carAssemblyRec(a, t, e, x, n-1, 1) + t[1][n] + a[0][n]);    
    }else if(line == 1){       
        T1 = Math.min(carAssemblyRec(a, t, e, x, n-1, 1) + a[1][n],             
                             carAssemblyRec(a, t, e, x, n-1, 0) + t[0][n] + a[1][n]);   
    }  

    return Math.min(T0, T1);  
}