for(i=0;i<n-diff;i++) {
    if(a[i]>a[i+diff]) {
        temp=a[i];
        a[i]=a[i+diff];
        a[i+diff]=temp;
        interchange=1;
    }
}