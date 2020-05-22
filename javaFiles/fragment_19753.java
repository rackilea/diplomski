StringBuilder sb = new StringBuilder();
sb.append(arr[length-1]);

for (int x = arr.length-2; x>=0; x--) {
    sb.append(Math.abs(arr[x]));
}
String check = sb.toString();
System.out.println(check);