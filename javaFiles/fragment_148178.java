String command1 = "INSERT INTO Drivers (IDNumber, FirstName, LastName) VALUES (?, ?, ?)";
PreparedStatement ps = connection.prepareStatement(command1);
ps.setInteger(1, drivID );
ps.setString(2, FName );
ps.setString(3, LName );
ps.execute();