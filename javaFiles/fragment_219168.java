int[] garbage = new int[input.length];
int j = 0;
for (int i=0; i < input.length; i++){
    if (input[i] >= 0 && input[i] <= 9){
        garbage[j] = input[i];
        j++;
        System.out.print(garbage[j]);
    }