int num2replace = keyboard.nextInt();
int count = 0;
for (int i = 0; i < bLength; i++) {
    if (baseString.charAt(i) == char2replace.charAt(0)) {
        count++;
        if (count == num2replace){
            baseString = baseString.substring(0, i) +
                    secondChar + baseString.substring(i + 1);
            break;
        }
    }
    if (char2replace.length() > 1) {//you need move this out of loop
        System.out.println("Error you can only enter one character");
    }


}
System.out.println(baseString);