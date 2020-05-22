try{

                connection = DriverManager.getConnection( 
     "jdbc:mysql://localhost:3306/sakila", "root", "MySQL2019.");

                selectActors = connection.prepareStatement(
                    "SELECT actor_id, first_name, last_name FROM actor");

            }catch (SQLException e){

                e.printStackTrace();
            }