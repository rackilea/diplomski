jdbcTemplate.query(sqlQuery, new PreparedStatementSetter() {
                public void setValues(PreparedStatement preparedStatement) throws SQLException {                    
                 preparedStatement.setObject(1, arg1); //example for arg1
                 preparedStatement.setObject(2, arg1);
                 ... //inside this method I just process every argument by setting specific numbers of occurrences in cycle
                }
            }, rowMap);