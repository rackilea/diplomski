public static void main(String args[]) {
    Scanner userInput = new Scanner(System.in);
    System.out.print("Enter a word or phrase: ");
    String str = userInput.nextLine();

    //if input contains spaces call reversePhrase otherwise reverseWord
    //str.contains(" ") is IMO cleaner, but you can change it to str.indexOf(" ") > -1 if you find it better
    if(str.contains(" ")){
        System.out.println(reversePhrase(str));
    }
    else{
        System.out.println(reverseWord(str));
    }
}

private static String reverseWord(String input) {
    String result = "";
    for(int i = input.length()-1; i >= 0; i--){
        result = result + input.charAt(i);
    }
    return result;
}

private static String reversePhrase(String input) {
    String result = "";
    while(input.contains(" ")){
        result = result + input.substring(input.lastIndexOf(" ")+1) + " ";
        input = input.substring(0, input.lastIndexOf(" "));
    }
    return result + input;
}