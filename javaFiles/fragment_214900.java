final Set<Integer> set = Arrays.stream(permissions)
                               .map(Role::getRoleId)
                               .collect(Collectors.toSet());

roleNames = Arrays.stream(roles)
                  .filter(role -> set.contains(role.getRoleId()))
                  .map(Role::getRoleName)
                  .collect(Collectors.toList());