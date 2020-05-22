line_delimiter = "||";
column_delimiter = "|";

String rows[];
rows = str.split(line_delimiter);
for (int i = 0; i < rows.length; i++) {
    String columns[];
    columns = rows[i].split(column_delimiter);
    for (int j = 0; j < columns.length; j++) {
        // Do something to your data here;
    }
}