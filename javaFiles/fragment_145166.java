List<User> usersInSpecificProject =
  allUsers.stream()
        .filter(u -> u.getProjects().stream()
                                    .map(Project::getId)
                                    .anyMatch(pid -> pid.equals(projectId)))
        .collect(Collectors.toList());