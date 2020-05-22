final ObjectMapper mapper = new ObjectMapper();
mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);

final ObjectWriter writer = mapper
        .writerWithView(Views.ShutdownView.class);
final Product product = new Product(new ProductEntity("Widget",
        BigDecimal.valueOf(10)), new Priority("high"));
System.out.println(writer.writeValueAsString(product));