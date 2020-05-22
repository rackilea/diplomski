List<UserDTO> result = Arrays.asList(te).stream()
        .map(x -> x.replace(ISConstants.domainName, ""))
        .filter(x -> !x.contains("_") ? 
                     ArrayUtils.contains(con, x.toLowerCase()) : 
                     ArrayUtils.contains(con, x.split("_")[0].toLowerCase()))
        .filter(x -> !x.equalsIgnoreCase("b"))
        .map(x -> {
                     UserDTO u = new UserDTO();
                     u.setUserName(x);
                     return u;
         })
        .collect(Collectors.toList());