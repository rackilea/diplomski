MvcResult result = mockMvc.perform(get(getUri("/consumers/1/persons")))
        .andExpect(status().isOk())
        .andReturn();

ObjectMapper mapper = new ObjectMapper();

// this uses a TypeReference to inform Jackson about the Lists's generic type
List<PersonDto> actual = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<PersonDto>>() {});

// now just assert equality (or whatever) against the actual PersonDto