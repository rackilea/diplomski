public static void main(String[] args) {
    String start = "02071231234";
    String end = "02071231237";
    String leadingZeros = "";
    List<String> numbersFromStartToEnd = new ArrayList<String>();

    // get leading zeros (makes the assumption that all numbers will have same qty of leading zeros)
    for(char digit : start.toCharArray()) {
        if(digit != '0') { break; }
        leadingZeros += "0";
    }

    // set up your BigInts
    BigInteger s = new BigInteger(start);
    BigInteger e = new BigInteger(end);
    BigInteger one = new BigInteger("1");

    // collect all numbers from start to end (adding on any leading zeros)
    while (s.compareTo(e) <= 0) {
        numbersFromStartToEnd.add(leadingZeros + s.toString());
        s = s.add(one);
    }

    // print the result
    for(String string: numbersFromStartToEnd) {
        System.out.println(string);
    }
}