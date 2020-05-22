public static void duplicates(int[] input, int[] output){
    for (int q = 0; q < input.length; q++){
        if (!contains(output, input[q]) || 
                indexOf(output, input[q]) == -1 || 
                count(output, input[q]) == 0){ // # of times the current input appears in 
                // output should be zero
            output[q] = input[q];
        }
    }
}