public static void addRecord(DVD dvd) throws SQLException{
                PreparedStatement pStatement = 
getConnection().prepareStatement("insert into products(movieName, movieRate, movieYear, moviePrice) values(?,?,?,?)");
                pStatement.setString(1, dvd.getMovie());
                pStatement.setString(2, dvd.getRating());
                pStatement.setString(3, dvd.getYear());
                pStatement.setDouble(4, dvd.getPrice());
                pStatement.executeUpdate();
            }