while (!normText.equals("q")) {
    String cipherText = shift.encryptionMethod(normText, caesarShift);
    System.out.println("Your normal text is: " + normText);
    System.out.println("Your text after encryption is: " + cipherText);
    String cnormText = shift.decryptionMethod(cipherText, caesarShift);
    System.out.println("Your encrypted text is: " + cipherText);
    System.out.println("Your decrypte text is: " + cnormText);

    System.out.println("What is the text you would like to do something with?(q to quit)");
    normText = in.nextLine();
}