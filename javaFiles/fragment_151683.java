int minLen = Math.min(test1.length, test2.length);
String commonPrefix = "";

for (int i = 0; i < minLen; i++) {
    if (test1[i].compareTo(test2[i]) == 0) {
        commonPrefix += test1[i]+"/";
    } else {
        break;
    }
}