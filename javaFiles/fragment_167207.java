int[] values = {2,5,3,2,1,4,6,3,2,1,5,3};
int result=1;
for(int value : values) {
    result *= value;
} 
System.out.println("The result: " + result); //Will print the result of 2*5*3*2*...