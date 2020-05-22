int littleStringPos = bigString.indexOf(littleString);
if (littleStringPos >= 0) 
    System.out.println("The character after thelittle string is: " + 
        bigString.charAt(littleStringIdx + littleString.length()));
else
    System.out.println("The little string isn't there!");