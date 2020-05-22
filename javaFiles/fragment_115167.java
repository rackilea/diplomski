for(int i = 0;i<n;i++){
    for(int j = 1;j<=(n-1)*(n-2)*(n-3)/6;j++){
        int p1 =  j      % 4;
        int p2 = (j + 1) % 4;
        int p3 = (j + 2) % 4;
        demoMethod(p1,p2,p3);
    }
}