public static void main(String[] args) {
    BGNEncryption b = new BGNEncryption();
    PublicKey PK = b.gen(32);

    Element msg1 = b.encrypt(PK, 32);
    Element msg2 = b.encrypt(PK, 15);

    Element add = b.add(PK, msg1, msg2);
    System.out.println("Addition: " + b.decrypt(PK, b.q, add));

    Element mul = b.mul(PK, msg1, msg2);
    System.out.println("Mul: " + b.decryptMul(PK, b.q, mul));
}