int sum = start;
String result = String.valueOf(start);
for (int i = start + 1; i <= end; i++) {
    result += "+" + i;
    sum += i;
}
result += "=" + sum;
// System.out.println(result);
return result;