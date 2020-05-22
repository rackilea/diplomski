String str = "abc";  // or anything else

StringBuilder sb = new StringBuilder();
for (char c : str.toCharArray())
    sb.append((int)c);

BigInteger mInt = new BigInteger(sb.toString());
System.out.println(mInt);