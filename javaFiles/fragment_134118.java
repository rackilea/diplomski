public static void printStatus(char c){
    String mystring = "abcdefghijklmnopqrstuvwxyz";
    int count = 0; 
    StringBuilder sb = new StringBuilder();
    sb.append(mystring);

    for (int i = 0; i < sb.length(); i++){
        if (c ==sb.charAt(i)){
            sb.deleteCharAt(i);
        }
    }
    guesses++;
    System.out.println(sb.toString());
    System.out.println("The number of guesses are: " + guesses);
}