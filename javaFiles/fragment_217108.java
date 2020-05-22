int sum = start;
String result = String.valueOf(start);
for (int i = start + 1; i <= end; i++) {
    result = result + "+" + i;
    sum = sum + i;
}
result = result + "=" + sum;
// System.out.println(result);
return result;