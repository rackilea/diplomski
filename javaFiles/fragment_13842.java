int len = arrayOfString1.length;
len = Math.max(len, arrayOfString2.length);
len = Math.max(len, arrayOfString3.length);
for (int i = 0; i < len; i++) {
    if (i < arrayOfString1.length) System.out.println("arrayOfString1" + arrayOfString1[i]);
    if (i < arrayOfString2.length) System.out.println("arrayOfString2" + arrayOfString2[i]);
    if (i < arrayOfString3.length) System.out.println("arrayOfString3" + arrayOfString3[i]);
}