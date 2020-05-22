ObjectMapper mapper = new ObjectMapper();

try {
    response.getWriter().write(mapper.writeValueAsString(result));
    out.flush();
} catch (JsonGenerationException e) {

    e.printStackTrace();

} catch (JsonMappingException e) {

    e.printStackTrace();

} catch (IOException e) {

    e.printStackTrace();

}