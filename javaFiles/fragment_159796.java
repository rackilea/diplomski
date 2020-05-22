int open_par = 0;
for(int i=index;i--!=0;){
   if(str.charAt(i)=='(')
      open_par++; //count open parenthesis
   if(str.charAt(i)==')')
      open_par--; //count closed parenthesis
}
return open_par>0; //if open parenthesis exceeds closed parenthesis