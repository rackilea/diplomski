md.update( seq20 ); 
byte[] md5sum = md.digest();
BigInteger bigInt = new BigInteger(1, md5sum);
output = bigInt.toString(16);
while ( output.length() < 32 ) {
    output = "0"+output;
}