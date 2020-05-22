int[] arr= {-1, -2, 0, 1, 2};
int p=0;
int n=0;

for(int i=0; i<arr.length-1; ++i) {
  if(arr[i]>=0) {
    p=p+1;
  } else {
    n=n+1;
  }
}

int[] posarr=new int[p];
int[] negarr=new int[n];
p=0;
n=0;
for(int i=0; i<arr.length-1; ++i) {
  if(arr[i]>=0) {
    posarr[p]=arr[i];
    p=p+1;
  } else {
    negarr[n]=arr[i];
    n=n+1;
  }
}