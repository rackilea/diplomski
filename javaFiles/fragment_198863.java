List<UserDTO> resultSet = 
       users.stream()
            .map(user -> Optional.ofNullable(individualsMap.get(user.getIndividualId()))
                    .map(i -> new AbstractMap.SimpleEntry<>(i, user.getUserId())).orElse(null))
            .filter(Objects::nonNull)
            .map(e -> new UserDTO(e.getValue(), e.getKey().getFirstName(), e.getKey().getLastName()))
            .collect(Collectors.toList());