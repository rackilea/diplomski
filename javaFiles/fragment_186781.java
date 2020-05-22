String fPattern = "0.00000000000000000"; //please supply the right format pattern
 DecimalFormat dFormat = new DecimalFormat(fPattern);
 StringBuilder builder = new StringBuilder(n*n);
 for (i = 0; i < n; i++){
    for(j = 0; j < n; j++){
      builder.append(dFormat.format(matrix[i][j]));
      builder.append(",");
    }
    builder.append("\n");
 }