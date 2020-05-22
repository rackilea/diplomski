//configure input format using
    CsvParserSettings settings = new CsvParserSettings();

    //get an interator
    CsvParser parser = new CsvParser(settings);
    Iterator<String[]> it = parser.iterate(new File("/path/to/your.csv"), "UTF-8").iterator();

    //connect to the database and create an insert statement
    Connection connection = getYourDatabaseConnectionSomehow();
    final int COLUMN_COUNT = 2;
    PreparedStatement statement = connection.prepareStatement("INSERT INTO some_table(column1, column2) VALUES (?,?)"); 

    //run batch inserts of 1000 rows per batch
    int batchSize = 0;
    while (it.hasNext()) {
        //get next row from parser and set values in your statement
        String[] row = it.next(); 
        for(int i = 0; i < COLUMN_COUNT; i++){ 
            if(i < row.length){
                statement.setObject(i + 1, row[i]);
            } else { //row in input is shorter than COLUMN_COUNT
                statement.setObject(i + 1, null);   
            }
        }

        //add the values to the batch
        statement.addBatch();
        batchSize++;

        //once 1000 rows made into the batch, execute it
        if (batchSize == 1000) {
            statement.executeBatch();
            batchSize = 0;
        }
    }
    // the last batch probably won't have 1000 rows.
    if (batchSize > 0) {
        statement.executeBatch();
    }