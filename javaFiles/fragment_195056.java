while ((read = in.readLine()) != null) {
            String[] splited = read.split("\\s+");
            name=splited[0];
            age=splited[1];
            height=splited[2];
            weight=splited[3];   
            addpatient(connection, preparedstatement, name, age, height, weight);   
         }

if (connection != null)
            try{connection.close();} catch(SQLException ignore){}
            }