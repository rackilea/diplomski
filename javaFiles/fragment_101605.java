if (r1 > r2) {
     int t = r1;
     r1 = r2;
     r2 = t;
}
StringBuilder sb = new StringBuilder();
while (r1 > 0) {
    int temp = r2 % r1;
    sb.append("r1=").append(r2).append("     r2=").append(r1).append("       q=").append(r2/r1).append("      r=").append(temp).append('\n');
    r2 = r1;
    r1 = temp;
}
sb.append("gcd=").append(r2);
label.setText(sb.toString());