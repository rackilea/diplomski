ObjectMapper mapper = new ObjectMapper();
TypeResolverBuilder<?> typer = new ObjectMapper.DefaultTypeResolverBuilder(ObjectMapper.DefaultTyping.OBJECT_AND_NON_CONCRETE);
typer = typer.init(JsonTypeInfo.Id.CLASS, null);
typer = typer.inclusion(JsonTypeInfo.As.PROPERTY);
typer = typer.typeProperty("type");
mapper.setDefaultTyping(typer);