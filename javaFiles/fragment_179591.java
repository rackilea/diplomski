List<String> value = entry.getValue();
String timeEntries = value.toString();
String after = timeEntries.replace(",", " ");
String after2 = after.replace("  ", " ");
String after3 = after2.replace("[", "");
String after4 = after3.replace("]", "");