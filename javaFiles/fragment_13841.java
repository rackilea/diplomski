int len = arrayOfString1.size();
len = Math.max(len, arrayOfString2.size());
len = Math.max(len, arrayOfString3.size());
for (int i = 0; i < len; i++) {
    if (i < arrayOfString1.size()) System.out.println("arrayOfString1" + arrayOfString1.get(i));
    if (i < arrayOfString2.size()) System.out.println("arrayOfString2" + arrayOfString2.get(i));
    if (i < arrayOfString3.size()) System.out.println("arrayOfString3" + arrayOfString3.get(i));
}