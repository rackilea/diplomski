@Test 
public void testJackson() throws JsonProcessingException {

    Obsidian obs = new Obsidian();
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValueAsString(obs);
}