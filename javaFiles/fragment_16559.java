User user1 = new User("001", "mama", "hyd", new String[]{"java", "spring", "bootStrap"});
User user2 = new User("002", "gugu", "mumbai", new String[]{"java", "spring", "hibernate"});
User user3 = new User("003", "lali", "pune", new String[]{"angularjs"});
User user4 = new User("004", "asu", "kashmir", new String[]{"java"});

List<User> list1 = new ArrayList<User>();
list1.add(user1);
list1.add(user2);
list1.add(user3);
list1.add(user4);

// convert the list of users into a map of skills to users with that skill
Map<String, List<User>> skillsMap = new HashMap<>();
for (User user : list1) {
    for (String skill : user.getSkills()) {
        skillsMap.computeIfAbsent(skill, (key) -> new ArrayList<>()).add(user);
    }
}

// find the largest list of users with a skill
List<User> mostUsers = null;
for (List<User> usersWithSkill : skillsMap.values()) {
    if (mostUsers == null || usersWithSkill.size() > mostUsers.size()) {
        mostUsers = usersWithSkill;
    }
}

// print the ids of the users in the largest user list
for (User user : mostUsers) {
    System.out.println(user);  // assumes there is a valid toString() method for User
}