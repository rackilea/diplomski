public static int getInt(Scanner s) throws EOFException {
    while (true) {
        if (s.hasNextInt())
            return s.nextInt();
        String next = s.next();
        if (next.equals("exit"))
            throw new EOFException();
        System.out.println(next + " is not a valid number. Try again:");
    }
}