private final ObjectMapper objectMapper = new ObjectMapper();

@RequestMapping(value = "/thing/{id}")
public void getThing(@PathVariable final String id, HttpServletResponse response) {
    Thing thing = new Thing();
    objectMapper.writeValueUsingView(response.getWriter(), thing, Views.ExtendPublic.class);
}