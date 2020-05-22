import java.sql.*;

ConnD = DriverManager.getConnection(...
'jdbc:mysql://localhost/?user=urname&password=urpassword');

sD=ConnD.createStatement();
Result=sD.executeUpdate('CREATE DATABASE urdatabasename');
sD.close();
ConnD.close();