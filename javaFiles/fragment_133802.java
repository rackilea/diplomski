long k = 0;
while (true) {
    String pwd = Long.toString(k++, 36);
    if (SHA1(pwd).equals(hashedPassword)) {
        System.out.println(pwd);
    }
}