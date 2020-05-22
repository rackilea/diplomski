public void executeInsertStmt(String strQuery, List<ParamDescriptor> parameters) throws SQLException {    
        PreparedStatement preparedStatement = cnx.prepareStatement(strQuery);

        int counter = 1;
        for (ParamDescriptor paramDescriptor : parameters) {
            preparedStatement.setObject(counter, 
                                        paramDescriptor.getValue(),
                                        paramDescriptor.getDataType());
            counter++;
        }
    }