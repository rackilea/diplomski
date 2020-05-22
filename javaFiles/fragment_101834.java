// Create input reader
BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

// Prompt, then wait and get user input for the plaintext 
System.out.println("Enter Text that you want to encrypt:");
String plainText = userInput.readLine();

// Prompt, then wait and get user input for the key
System.out.println("Enter the key:");
String key = userInput.readLine();

// Actually encrypt it
byte[] encrypted = MARS.encrypt(plainText.getBytes(), key.getBytes());

// Print encrypted and unencrypted
System.out.println("Plain text: " + plainText);
System.out.println("Encrypted Text: " + new String(encrypted));