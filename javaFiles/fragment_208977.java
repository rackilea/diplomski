if (matcher1.find()) {
    i = matcher1.start();
    j = matcher1.end();
    String temp1 = para2.substring(i, j-1); // Use (j-1) to skip last space character
    System.out.println(temp1);
}