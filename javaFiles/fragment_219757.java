final String procedureCall = "{call DRILL_RECORD_POSITION(?, ?, ?, ?, ?, ?, ?, ?)}";

      try (Connection connection = jdbcTemplate.getDataSource().getConnection();) 
      {
          ArrayList<String> inner = new ArrayList<String>();
          CallableStatement callableSt = connection.prepareCall(procedureCall);
          callableSt.setString(1, "D");

          callableSt.registerOutParameter(2, Types.VARCHAR);
          callableSt.registerOutParameter(3, Types.VARCHAR);
          callableSt.registerOutParameter(4, Types.VARCHAR);
          callableSt.registerOutParameter(5, Types.VARCHAR);
          callableSt.registerOutParameter(6, Types.VARCHAR);
          callableSt.registerOutParameter(7, Types.VARCHAR);
          callableSt.registerOutParameter(8, Types.VARCHAR);

          //Call Stored Procedure
          callableSt.executeUpdate();

          for (int i=2; i<9; i++)
          {
               System.out.println(callableSt.getString(i));
          }
      }catch (SQLException e) {
        e.printStackTrace();
      }