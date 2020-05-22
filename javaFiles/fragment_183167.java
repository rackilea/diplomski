String loanIds = "[\"1505213753057\",\"1505213854042\",\"1505537148455\"]";

loanIds = loanIds.replaceAll("(\\[\")|(\"\\])", "").replaceAll("\",\"", ",");
String [] loanId = loanIds.split(",");
Long[] data = new Long[loanId.length];
for (int i = 0; i < loanId.length; i++) {
    data[i] = Long.parseLong(loanId[i]);
    System.out.println(data[i]);
}