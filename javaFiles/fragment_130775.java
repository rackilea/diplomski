Page<Person> page = new PageImpl<>(new ArrayList<>());
   when(pepleService.getPeopleSystems(any(Pageable.class))).thenReturn(page);
   mockMvc.perform(get("/people")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(header().string("CustomHeader1", "2000"));