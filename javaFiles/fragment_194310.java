SqlTypeValue structArray = new AbstractSqlTypeValue() {
                @Override
                protected Object createTypeValue(Connection connection, int arg1, String arg2) throws SQLException {
                    Object[] modelArray = new Object[request.getArray().size()];
                    int i = 0;
                    for (Iterator<Model> iterator = request.getArray().iterator(); iterator.hasNext();) {
                        Model model = (Model) iterator.next();
                        Struct s = connection.createStruct("TEST_REC", new Object[] { 
                          // All attributes go here
                        });
                        modelArray[i++] = s;
                    }
                    Array structArray = ((OracleConnection) connection).createOracleArray("TEST_STRUCT",
                            modelArray);
                    return structArray ;
                }
            };