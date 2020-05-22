BigInteger subtrahend = new BigInteger("2D", 16); 
// input, you can take input from user and use after validation
char[] array = new char[subtrahend.toString(16).length()];
// construct a character array of the given length
Arrays.fill(array, 'F');
// fill the array by F, look at the first source there the FF is subtracted by 2D
BigInteger minuend = new BigInteger(new String(array), 16);
// construct FFF... Biginteger of that length
BigInteger difference = minuend.subtract(subtrahend);
// calculate minus
BigInteger result = difference.add(BigInteger.ONE);
// add one to it
System.out.println(result.toString(16));
// print it in hex format