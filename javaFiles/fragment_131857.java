boolean present = 
        Optional.ofNullable(map)
                .filter(x -> 
                        x.values().stream()
                                  .noneMatch(s -> s != null && s.trim().isEmpty()))
                                  .isPresent();