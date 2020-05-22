public static List<User> filter(List<User> users) {
        Set<User> set = new HashSet<>();
        List<User> uniqueUsers = new ArrayList<>();
        List<User> doubleUsers = new ArrayList<>();
        Map<Boolean, List<User>> partitions = users.stream().collect(Collectors.partitioningBy(user -> set.add(user) == true));
        uniqueUsers.addAll(partitions.get(true));
        doubleUsers.addAll(partitions.get(false));
        uniqueUsers.removeAll(doubleUsers);
        return uniqueUsers;
    }