this.outputParameters.add(new SqlOutParameter(outputParamName, VARCHAR, new RowCallbackHandler() {
  public void processRow(ResultSet rs) throws SQLException { 
      // Build model object from ROW and invoke client service from here
  }
}));

 jdbcCall.execute(arguments);