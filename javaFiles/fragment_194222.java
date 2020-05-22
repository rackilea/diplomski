public static String circularShiftBinary(long binaryNumber, int shift)
{
    String bin = Long.toString(binaryNumber);
    //check that the shift isn't a fully circular shift
    if(shift % bin.length() != 0)
        while(shift-- > 0)
            bin = bin.charAt(bin.length() - 1) + bin.substring(0, bin.length() - 1);

    return bin;
}