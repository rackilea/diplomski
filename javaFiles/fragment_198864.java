List<UserDTO> resultSet = 
        users.stream()
             .flatMap(user -> Optional.ofNullable(individualsMap.get(user.getIndividualId()))
                        .map(i -> Map.entry(i, user.getUserId())).stream())
             .map(e -> new UserDTO(e.getValue(), e.getKey().getFirstName(), e.getKey().getLastName()))
             .collect(Collectors.toList());