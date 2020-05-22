Statement statement = con.createStatement();
    ResultSet result = statement.executeQuery("select username, age, nickname from user where nickname is not NULL");
    List<User> allUserNullNickname = new ArrayList<>();
    while(result.next()){
        User user = new User();
        user.setUsername(result.getString("username"));
        user.setAge(result.getInt("age"));
        allUserNullNickname.add(user);
    }
    System.out.println("All user without nickname:");
    allUserNullNickname.stream().forEach(user -> System.out.println("username: "+user.getUsername()+" Age: "+user.getAge()));