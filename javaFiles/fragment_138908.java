String result = "WIN";
...
for(int i=0; i<n; i++){ 
 if(b[i] < a[i])
  result = "LOSE";
}
System.out.println(result);