StringBuilder sb = new StringBuilder(String.valueOf(start));
int sum = IntStream.rangeClosed(start, end).sum();
IntStream.rangeClosed(start + 1, end).forEach(x -> sb.append("+").append(x));
sb.append("=").append(sum);
// System.out.println(sb);
return sb.toString();