char[] buffer = { 'M','r',' ','J','o','h','n',' ','S','m','i','t','h','*','*','*','*' };
int inLen = 13;
System.out.println("buffer: '" + new String(buffer) + "'");
System.out.println("inLen : " + inLen);
System.out.println("input : '" + new String(buffer, 0, inLen) + "'");
int outLen = replaceSpaces(buffer, inLen);
System.out.println("outLen: " + outLen);
System.out.println("result: '" + new String(buffer, 0, outLen) + "'");