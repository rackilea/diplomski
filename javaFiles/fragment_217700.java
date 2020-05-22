Session session = entityManager.unwrap(Session.class);
      CallableStatement callableStatement =  session.doReturningWork(new ReturningWork<CallableStatement>() {
            @Override
            public CallableStatement execute(Connection connection) throws SQLException {
                CallableStatement function = connection.prepareCall(
                        "{ ? = call package_name.function_name(?,?) }");
                function.registerOutParameter(1, Types.INTEGER);
                function.setLong(2, 56);
                function.setString(3,"some text");

                function.execute();
                return function;
            }
        });

        try {
            return callableStatement.getBigDecimal(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }