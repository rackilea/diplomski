String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

for (char ch : alphabet.toCharArray()) {
   String columnPattern = ch + "%";
   ResultSet rs = metaData.getColumns(null, null, name, columnPattern);
   ...
}