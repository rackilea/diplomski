String str = "Is Mississippi a State where there are many systems.";
System.out.println(str);

char[] cArray = str.toCharArray();
boolean isFirstS = true;
for (int i = 0; i < cArray.length; i++) {
    if ((cArray[i] == 's' || cArray[i] == 'S') && isFirstS) {
        cArray[i] = (cArray[i] == 's' ? 't' : 'T');
        isFirstS = false;
    } else if (Character.isWhitespace(cArray[i])) {
        isFirstS = true;
    }
}
str = new String(cArray);

System.out.println(str);