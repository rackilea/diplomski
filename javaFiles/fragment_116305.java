return
   userTypes.stream()
            .filter(StructUserType.class::isInstance)
            .map(StructUserType.class::cast)
            .filter(st -> st.getMembers()
                            .stream()
                            .anyMatch(m -> m.getId().equals(id)))
            .findFirst()
            .orElse(null);