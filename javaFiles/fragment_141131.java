@Then("I validate the following columns: \"$columns\" from database")
public void then_i_walidate_columns_from_databale( List<String> columns){
    String columnsWithError = "";
    boolean validationResult = true;
    for( String column : columns){
        boolean validationResultOfCurrentColumn = ( null != getColumnFromDB(column));
        validationResult &= validationResultOfCurrentColumn;
        if( ! validationResultOfCurrentColumn ){
            columnsWithError += column + " ";
        }
    }
    Assert.assertTrue("The following columns don't pass the validation: " + columnsWithError, validationResult);
}