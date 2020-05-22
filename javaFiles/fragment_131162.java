int count=0;
if((second%10)==first){ 
    count++;
}
if(Math.round((second/10))==first){
    count++;
}
System.out.println(first+" occurs "+count+" times in "+second);