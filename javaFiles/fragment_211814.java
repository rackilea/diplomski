try( Connection conn = pbds.getConnection() ) { 

    ... do stuff with conn

} catch (SQLException e) {          
    e.printStackTrace();
}