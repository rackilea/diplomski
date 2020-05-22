preparedStatement = dbConnection.prepareStatement("drop table if exists rate; "
                    + "create table rate(id int, restaurantname varchar(20)); "
                    + "insert into rate values(1,'a'),(2,'b'),(1,'a')");
            preparedStatement.execute();

            String updatesql ;
            updatesql = "delete from rate where  id = ? and restaurantname = ?";
//          dbConnection = db.getDBConnection();
            preparedStatement = dbConnection.prepareStatement(updatesql);
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2, "a");
//          db.setPreparedStatement(preparedStatement);
            int count = preparedStatement.executeUpdate();
            //System.out.println(count);
            boolean result = count > 0;
            System.out.println("count : " + count + ", result : " + result);