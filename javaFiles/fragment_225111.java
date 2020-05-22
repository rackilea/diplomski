//...connection builder
    connection.connect(); 
 AccountManager.getInstance(connection).sensitiveOperationOverInsecureConnection(true);
            username = username.toLowerCase();

                Map<String,String> attributes = new HashMap<String, String>(2);
                attributes.put("name", fullName);
                attributes.put("email", email);
        AccountManager.getInstance(connection).createAccount(username, password, attributes);
//now you can do connection.login(username,password)