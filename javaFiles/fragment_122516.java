...
for (int i = 0; i < columnCount; i++) {
    row[i] = rset.getString(i + 1);                    
}
System.out.println(Arrays.toString(row));
result.add(row);
...