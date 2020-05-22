byte[] array = new BigInteger("1111000011110001", 2).toByteArray();
byte[] secondArray = new BigInteger("1111000011110001", 2).toByteArray();
if (Arrays.equals(array, secondArray))
{
    System.out.println("Yup, they're the same!");
}