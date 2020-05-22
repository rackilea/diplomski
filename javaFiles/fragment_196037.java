String query = "select * from playerdata where username=? and password=?"; //makes a query in table "Login" searching for "username"s and "password"s

            PreparedStatement preparedStt = cnct.prepareStatement(query); //passing query to preparedStt (statement)

            //setting Strings for username and password 
            preparedStt.setString(1, userName.getText()); //index 1 for username (upper ?)
            preparedStt.setString(2, userPassword.getText()); //index 2 for username (upper ?) (index starts at 1)

            ResultSet resSet = preparedStt.executeQuery(); //executes query result to resSet

            int count = 0;
            int id = 0;
            while(resSet.next()) {
                count++; //increments counter
                id = resSet.getInt("id");
            }

            if(count == 1) { //goes one time if query matches user and pass
                System.out.println("Access granted!");
            } else { //otherwise login is incorrect
                System.out.println("Access denied!");
                System.exit(0);
            }

            //closes connection
            resSet.close();
            preparedStt.close();