public static void main(String[] args) throws NoSuchAlgorithmException {
    ...
}

or

public static void main(String[] args) {
    try {
        ...
    }
    catch (NoSuchAlgorithmException e) {
        System.err.println("I'm sorry, but MD5 is not a valid message digest algorithm");
    }
}