String str = "xiwx"; // encrypted string

String decryptedStr = ""; // start empty then add characters

for (char ch : str.toCharArray()) // loop through each character in str

    decryptedStr += (char) (ch - str.length()); // need to cast subtraction to char

System.out.println("Decrypted String: " + decryptedStr); // output decrypted string