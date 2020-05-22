String[][] coordinates = new String[cols][rows]; 

for (int i = 0; i < cols; i++) {
  for (int j = 0; j < rows; j++) { 

coordinates[i][j] = String.valueOf((char)(i+65)) + String.valueOf(j).toUpperCase();

  }
}