List<String> lines = new ArrayList<String>();
String zeile = null;
int max = 0;

while ((zeile = br.readLine()) != null) {
   lines.add(zeile);
   if (zeile.length() > max)
      max = zeile.length();
}

char[][] matrix = new char[lines.length()][max];

// populate the matrix:
for (int i = 0; i < lines.length(); i++) {
   String line = lines.get(i);
   for (int j = 0; j < line.length(); j++) {
       matrix[i][j] = line.charAt(j);
   }
}