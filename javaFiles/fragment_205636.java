ResultSet resultSet = dbase.getResultSet();

    // Configure the output format as needed before actually dumping the data:
    CsvWriterSettings writerSettings = new CsvWriterSettings(); //many settings here, check the tutorials & examples.
    writerSettings.getFormat().setLineSeparator("\n");
    writerSettings.setHeaderWritingEnabled(true); // we want the column names to be printed out as well.

    // Then create a routines object:
    CsvRoutines routines = new CsvRoutines(writerSettings);

    // The write() method takes care of everything. The resultSet and any other resources required are closed by the routine.
    routines.write(resultSet, new File(fileName), "UTF-8");