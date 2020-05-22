int end = num.length-1;
while(swapped){ 
   swapped = false;
   for(int i=0;i<end;i++){

        if(num[i]>num[i+1]){
            int temp = num[i];
            num[i] = num[i+1];
            num[i+1] = temp;
            swapped = true;
        }
    }
    end--;
 }