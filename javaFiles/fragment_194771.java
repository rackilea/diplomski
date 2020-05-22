StringBuilder sb = new StringBuilder(); 
if (numCount < 2) {
  sb.append("Not Enough Numbers in Password!");
  sb.append(System.getProperty("line.separator"));
}
if (capCount < 2) {
  sb.append("Not Enough Capital Letters in Password!");
  sb.append(System.getProperty("line.separator"));
}
if (length < 2) {
  sb.append("Password is Too Short!");
}

return sb.toString();