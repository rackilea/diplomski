...
StringBuffer sb = new StringBuffer();
sb.append("<root>");
for (String[] row: dataList) {
  sb.append("<entry>");
  sb.append("<ContractDate>").append(row[0]).append("</ContractDate>");
  // etc...
  sb.append("</entry>");
}
sb.append("</root>");
...