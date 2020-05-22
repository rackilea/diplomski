public static boolean contains(int[] input, int target) {
    for(int i = 0; i < input.length; i++){
        if (target == input[i]){
            return true;
        }
    }
    return false;
}

public static int indexOf(int[] input, int target) {

    //If the value isn't there, return -1
    if(contains(input, target) == false){
        return -1;
    }

    //Go find the value if we know it is in there
    for(int i = 0; i < input.length; i++){
        if (target == input[i]){
            return i;
        }
    } 
    //We should never get here
    return -1;   
}