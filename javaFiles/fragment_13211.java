SimpleFilterProvider filterProvider = new SimpleFilterProvider();
filterProvider.addFilter("academicPersonalInfoFilter",
        SimpleBeanPropertyFilter.serializeAllExcept("motherName", "fatherName"));

ObjectMapper mapper = new ObjectMapper();
mapper.setFilters(filterProvider);
mapper.writeValueAsString(academicInfo);