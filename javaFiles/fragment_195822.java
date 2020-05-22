public static String getCheckSum(String msg) {
    int sum = 0;
    for (int i = 0; i < msg.length(); i++) {
        sum += msg.charAt(i);
    }
    sum += 16; //adding CR and ETX AND ETB
    sum = sum % 256;
    String checksum = Integer.toHexString(sum).toUpperCase();
    if (checksum.length() == 1) {
        checksum = "0" + checksum;
    }
    //System.out.println("\n Check Sum is ="+checksum);
    return checksum;
}