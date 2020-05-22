ObjectMapper mapper = new ObjectMapper();
Wrapper wrapper = null;
try {
    wrapper = mapper.readValue(json, Wrapper.class);
} catch (Exception e) {
    System.out.println("Something went wrong:" + e.getMessage());
}