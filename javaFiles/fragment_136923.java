CharSequence chSeq = "AND ((:aks_num = -1) OR (aks_num = :aks_num AND ((:brn_num = -1) OR (brn_num = :brn_num))))";
Pattern p = Pattern.compile(":([a-z_]*)");
Matcher m = p.matcher(chSeq);

while (m.find()) {
  System.out.println("Found value: " + m.group(0)+". Captured : "+m.group(1));
}