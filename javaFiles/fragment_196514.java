public static String getChecksum(Serializable object, String algorithm)
            throws IOException, NoSuchAlgorithmException {

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos)) {

            oos.writeObject(object);
            oos.flush();
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(object.toString().getBytes());
            byte[] theDigest = md.digest();
            System.out.println("Without Object output stream="+DatatypeConverter.printHexBinary(theDigest));


            md.reset();
            System.out.println("object="+object+ " Written to ByteArray is="+baos.toString());
            md.update(baos.toByteArray());
            theDigest = md.digest();
            return DatatypeConverter.printHexBinary(theDigest);
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        System.out.println(getChecksum("water", "MD5")); 

    }