MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("whatever url");
request.contentType(MediaType.APPLICATION_FORM_URLENCODED);

//set key value pairs
//also the keys do not have to be unique, two keys of the same value will both get added 
request.param("key", "value");

MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
ResultActions resultActions = mockMvc.perform(request);
// make sure response is valid