if(a>9){
  b=a%10;
  c=a/10;
  result[9-i]=b;
  result[10-i]+=c;
} else {
  result[9-i]=a;
}