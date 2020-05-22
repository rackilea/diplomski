int sum = start;
StringBuilder sb = new StringBuilder();
sb.append(start);
for (int i = start + 1; i <= end; i++) {
    sb.append("+").append(i);
    sum += i;
}
sb.append("=").append(sum);
// System.out.println(sb.toString());
return sb.toString();