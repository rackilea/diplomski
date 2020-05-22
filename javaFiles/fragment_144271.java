List<User> userList = ... // your list

List<UserWithAge> usersWithAgeList = userList.stream()
        .map(user -> {
                // create UserWithAge instance and copy user name
                UserWithAge userWithAge = new UserWithAge();
                userWithAge.setName(user.getName());
                userWithAge.setAge(27);
                return userWithAge;
         })
         .collect(Collectors.toList()); // return the UserWithAge's as a list