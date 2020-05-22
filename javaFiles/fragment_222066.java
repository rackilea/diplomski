Map<String,Object> results = 
        getJdbcTemplate().queryForMap(
            "SELECT userName, password FROM tblusers WHERE userName = ? AND password = ?"
            , login.getUserName()
            , login.getPassword());

String dbUserName = (String)results.get("userName");
String dbPassword = (String)results.get("password");