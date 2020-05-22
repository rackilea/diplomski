K=1;
while(true) {
    k=K-1;
    for(n=0; n<=k; n++)
      x=-k+n; y=-n;       
    for(n=1; n<=k; n++)
      x=n; y=-k+n;        
    for(n=1; n<=k; n++)
      x=k-n; y=n;         
    for(n=1; n<=k-1; n++)
      x=-n; y=k-n;
    if x out of bounds or y out of bounds continue;
    K++;
    if(K>N/2) break;
}