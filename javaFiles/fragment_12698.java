Exactly right. I found solution about 6-7 hours ago. 
For server Start should be 

commandStart[2] = "cd "+path+" && java -jar derbyrun.jar server start -h 10.90.232.2"; 

and shutdown 

commandStop[2] = "cd "+path+" && java -jar derbyrun.jar server shutdown -h 10.90.232.2"; 

then server and client side connect with 

String connectionUrl = "jdbc:derby://10.90.232.2:1527/myDB"+
    ";create=false;" + "user=" +"\""+ unameTextField.getText() +
    "\""+ ";" + "password=" +"\""+ 
    new String (passwordPasswordField.getPassword()) +"\""+ ";";