public static void main(String[] args) {
    try {
        ObjectMapper mapper = new ObjectMapper();
        Claim claim = new Claim();
        claim.filterProperties(new String[]{"Sam", "Toyota"});
        System.out.println(mapper.writeValueAsString(claim));
    } catch (Exception e) {
        e.printStackTrace();
    }
}