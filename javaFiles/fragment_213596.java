StringBuilder sb = new StringBuilder(whatever);
if (whatever.charAt(p)=='0') {
    sb.setCharAt(p, '1');
} else {
    sb.setCharAt(p, '0');
}
whatever = sb.toString();