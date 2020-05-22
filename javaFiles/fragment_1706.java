String currentUserRole = // Get role from the current user

FilterProvider filterProvider = new SimpleFilterProvider()
        .addFilter("roleBasedPropertyFilter", 
                new RoleBasedPropertyFilter(currentUserRole));

ObjectMapper mapper = new ObjectMapper();
mapper.setFilterProvider(filterProvider);