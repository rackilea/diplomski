ObjectMapper _mapper = new ObjectMapper();
_mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
ObjectWriter objectWriter = _mapper.writerWithView(View1.class);

String json = objectWriter.writeValueAsString(bean);
System.out.println(json);