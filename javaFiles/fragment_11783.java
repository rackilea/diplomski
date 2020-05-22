int n=a.length;
int minNo=a[0];
int maxNo=a[0];

for(int i=1;i<n;i++)
{
     if(a[i] > maxNo) {
         maxNo = a[i];
     } else if(a[i] < minNo) {
         minNo = a[i];
     }
}

// do whatever you want with maxNo and minNo