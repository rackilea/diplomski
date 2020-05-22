@Override
public Cipher createNew() {
    try {
        System.out.print("Instances : " + instance);
        Cipther result = Cipher.getInstance(this.instance);
        result.init(...); // use the right init params, e.g. opmode, crypto key
        return result;
    } catch (NoSuchAlgorithmException | NoSuchPaddingException se) {
        throw new IllegalArgumentException(
                "Unable to create new cipher", se);
    }
}