int[] firstInput ={1,9,4,2,1,9,4,2};
int[] secondInput ={3,1,6,a,b,2,c,b};
int[] output = new int[8];
for(i=0;i<firstInput.length();i++){
     output[i]=firstInput[i]^secondInput[i];
}