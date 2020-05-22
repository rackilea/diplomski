int smallest=Integer.MAX_VALUE;//assume smallest to be largest integer
for(int i=0;i<100;i++){
    int num=sc.nextInt();//this will run 100 times and hence will input 100 number
    if(num<smallest){//if number is smaller than smallest then num is smallest
       smallest=num; 
    }
}
System.out.println(smallest);