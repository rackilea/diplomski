String encryptMe = "He";
StringBuilder builder = new StringBuilder();
for (Character c : encryptMe.toCharArray() ) {
  builder.append(encryptionMap.get(c));
}
String encrypted = builder.toString();