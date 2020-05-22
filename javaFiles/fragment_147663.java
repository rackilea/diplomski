String[][] array = { { "a", "b" }, { "c" } };

String lineSeparator = System.lineSeparator();
StringBuilder sb = new StringBuilder();

for (String[] row : array) {
    sb.append(Arrays.toString(row))
      .append(lineSeparator);
}

String result = sb.toString();