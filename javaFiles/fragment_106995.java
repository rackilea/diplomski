String s = "I Love java Programs";
 String[] strArr = s.split(" ");
 for (int i = 0; i < strArr.length; i++) {
    String str = strArr[i];
    int min = Math.min(i + 1, str.length());
    String finalStr = str.substring(0, min) + (str.substring(min, str.length())).toUpperCase();
    System.out.print(finalStr + " ");
 }