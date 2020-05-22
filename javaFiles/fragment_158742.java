String myString = "[0.01,3.45],[5.674,8.712],[4.321,8.892],[3.412,6.781]";
// remove start and close brackets
myString = myString.substring(1, myString.length() - 1);
String[] result = myString.split("\\],\\[");
System.out.println(Arrays.toString(result));
// [0.01,3.45, 5.674,8.712, 4.321,8.892, 3.412,6.781]