public static void main(String[] args) throws Exception{
    String word="believe";  
    char[][] arr = getSplittedString(word);
    System.out.println("The array is: "+Arrays.deepToString(arr));
    for(char[] c : arr){
        System.out.print(c);
        System.out.print(' ');
    }
}

public static char[][] getSplittedString(String word){
    char[] new_word = word.toCharArray();
    char[][] word_splitted = new char[word.length()/2 + word.length()%2][];
    int j = 0;
    for(int i = 0; i < word.length()/2; i++){
        word_splitted[i] = new char[] {new_word[j++],new_word[j++]};
    }
    if(word.length()%2 != 0){
        word_splitted[word_splitted.length-1] = new char[]{new_word[j]};
    }
    return word_splitted;
}