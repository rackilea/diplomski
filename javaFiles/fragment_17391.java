String ipv6 = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
String[] spl = ipv6.split(":");
String result = "", del = "";
for (String s : spl) {
    result += del
            + String.format("%16s", new BigInteger(s, 16).toString(2)).replace(' ', '0');
    del = " ";
}
System.out.println(result);