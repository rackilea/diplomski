@Test 
public void testJackson() throws JsonProcessingException {
    Obsidian obs = new Obsidian();
    Gson gson = new Gson();
    gson.toJson(obs);
}