// This is a more concise and easier to read version 
public static int indexOfG(String str){

    for(int i = 0; i < str.length(); ++i){
        if(str.charAt(i) == 'G' || str.charAt(i) == 'g') return i;
    }
    return -1;
}