Complex1D X;
X.x=new double[N];
X.y=new double[N];
for(k=0;k<N;k++) X.x[k]=x[k];

fft.ft(X);