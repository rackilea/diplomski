protected void doPost(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
PrintWriter out = response.getWriter();

ObjectMapper mapper = new ObjectMapper();

try {
  // read from stream, convert it to generic class
  Map data = mapper.readValue(request.getReader(), Map.class);

} catch (JsonGenerationException e) {
  e.printStackTrace();
} catch (JsonMappingException e) {
  e.printStackTrace();
} catch (IOException e) {
  e.printStackTrace();
}


}