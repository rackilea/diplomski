String str = "test"; // normal string

String encryptedStr = ""; // start empty then add characters

for (char ch : str.toCharArray()) // loop through each character in str

    encryptedStr += (char) (ch + str.length()); // need to cast addition to char

System.out.println("Encrypted String: " + encryptedStr); // output encrypted string