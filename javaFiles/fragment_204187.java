private String spoolRow(ResultSet currentRow) 
{
    // Append each attribute to a StringBuilder in a nicely formatted way 
    // and return.
}

private void myMethod(....)
{
    ...
    ...
    FileOutputStream fos;
    String fileName;
    int counter = 1;
    while (rs.next()) {
        fileName = "row" + counter + ".txt";
        fos = new FileOutputStream(fileName);
        fos.write(spoolRow(rs));
        fos.close();
        counter++;
    }
    ...
    ...
}