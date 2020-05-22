String str = "1+2*-3/4-5";
    String newStr = "";

    for(int i = 0; i < str.length(); i++) {

        char perChar = str.charAt(i);

        if(perChar == '+' || perChar == '-' || perChar == '*' || perChar == '/'){
            if(str.charAt(i-1) == '+' || str.charAt(i-1) == '-' || str.charAt(i-1) == '*' || str.charAt(i-1) == '/'){
                newStr = newStr + perChar;
            } else {
                newStr = newStr + perChar + " ";
            }
        } else {
            newStr = newStr + perChar + " "; 
        }
    }
    System.out.println(newStr);