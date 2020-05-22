String line = "He is a boy .";
String[] arr = line.split(" ");
ArrayList<String> newLines = ArrayList<String>();
for (int i = 1; i < arr.length; i++){
  newLines.add(arr[i-1]+" "+arr[i]);
}