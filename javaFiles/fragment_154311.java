int a[]={1,1,2,2};
int b[]={1,1,1,1,3,3,2,2};
int ab[]=new int[b.length];

for (int i=0 ; i<b.length ; i++) {
    ab[i] = b[i] * a[i%a.length];
}