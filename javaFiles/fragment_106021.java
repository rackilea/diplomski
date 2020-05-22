String[] deecryptMe = new String[] { "{aeh}", "{wer}" };
StringBuilder builder = new StringBuilder();
for (String str : deecryptMe) {
  builder.append(deecryptionMap.get(str));
}
String decrypted = builder.toString();