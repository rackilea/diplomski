int a=2;
int b=3;
double pi=2;
for(int i=0;i<=n;i++){
   pi *= (double)a/(double)b;
  if(a>b){
    b+=2;
  } else {
    a+=2;
  }
}
pi*=2;