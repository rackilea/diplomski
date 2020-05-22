public static void main(String[] args) {
    String str = "55blhalhalh3265hezubf565";
    boolean isLetter = false;
    String temp = "";
    int sum = 0;

    for (int i = 0 ; i < str.length() ; i++){
        switch(str.charAt(i)){
        case '0': 
        case '1': 
        case '2': 
        case '3': 
        case '4': 
        case '5': 
        case '6': 
        case '7': 
        case '8': 
        case '9':
            isLetter = false;
            temp += str.charAt(i);
            break;
        default :
            if (!isLetter)sum += Integer.parseInt(temp);
            isLetter = true;
            temp = "";
            break;
        }
    }
    if (!isLetter) sum += Integer.parseInt(temp);

    System.out.println("The final sum is " + sum);
}