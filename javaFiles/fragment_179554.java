StringBuilder buff = new StringBuilder();
for (char c : list.toCharArray()) {
    buff.append(
        c=='G' ? 'A' :
        c=='A' ? 'G' :
        c=='T' ? 'C' :
        c=='C' ? 'T' :
        c // perhaps throw
    )
)
return buff.toString();