while(resultSet.next()) {
    for(int i = 1; i<=columnCount; i++{
        printer.print(resultSet.getString(i));
    }
    printer.println();
}