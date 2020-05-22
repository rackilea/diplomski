public Response list() throws JsonGenerationException, JsonMappingException, IOException
   {
      final TestAnno ta = getClass().getAnnotation( TestAnno.class );
      MyDto dto = buildDto(ta);

      return Response.ok(dto);
   }