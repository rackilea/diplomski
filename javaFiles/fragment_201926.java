boolean foundMatch = false;
for (int i = 0; i < str.length(); i++) {
    if ( (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) && (i-1 < 0 || str.charAt(i) != str.charAt(i-1)) ) {
        System.out.print(str.charAt(i));
        foundMatch = true;
    }
    else {
        if (foundMatch == true) break;
    }
}