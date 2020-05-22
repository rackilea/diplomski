Map<String, List<String>> userToGroup = new HashMap<String, List<String>>();
    userToGroup.put("John", Arrays.asList("GroupA"));
    userToGroup.put("Peter", Arrays.asList("GroupB", "GroupC"));
    userToGroup.put("Bob", Arrays.asList("GroupC"));
    userToGroup.put("Tom", Arrays.asList("GroupA", "GroupB"));
    userToGroup.put("Jack", Collections.<String> emptyList());

    Set<String> myGroups = new HashSet<String>(Arrays.asList("GroupA", "GroupB", "GroupC"));

    Map<String, Set<String>> groupToUsers = new HashMap<String, Set<String>>();
    groupToUsers.put("Generic", new HashSet<String>());
    for (String user : userToGroup.keySet()) {
        List<String> groups = userToGroup.get(user);
        if (groups.isEmpty()) {
            groupToUsers.get("Generic").add(user);
            continue;
        }

        for (String group : groups) {
            if (!myGroups.contains(group)) {
                continue;
            }

            Set<String> userInGroup = groupToUsers.get(group);
            if (userInGroup == null) {
                userInGroup = new HashSet<String>();
                groupToUsers.put(group, userInGroup);
            }

            userInGroup.add(user);
        }
    }

    System.out.println(groupToUsers);