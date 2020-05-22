class JTSPointConverterFactory implements Factory<Converter<Point>> {

    @Override public Converter<Point> create(Type type,
            Genson genson) {
        final Converter<Coordinate> coordianteConverter = genson.provideConverter(Coordinate.class);

        Converter<Point> pointConverter = new Converter<Point>() {
            private final GeometryFactory gf = new GeometryFactory(new PrecisionModel(), 4326);

            @Override public void serialize(Point point, ObjectWriter writer,
                    Context ctx) throws TransformationException, IOException {
                Coordinate coordinate = point.getCoordinate();

                writer.beginObject()
                        .writeName("x").writeValue(coordinate.x)
                        .writeName("y").writeValue(coordinate.y);

                if (!Double.isNaN(coordinate.z)) 
                    writer.writeName("z").writeValue(coordinate.z);

                writer.endObject();
            }

            @Override public Point deserialize(ObjectReader reader, Context ctx)
                    throws TransformationException, IOException {
                // just delegate to gensons Coordiante converter the deserialization
                return gf.createPoint(coordianteConverter.deserialize(reader, ctx));
            }
        };
        return pointConverter;
    }

}

// now register your factory
Genson genson = new Genson.Builder()
                            .withConverterFactory(new JTSPointConverterFactory())
                            .create();

genson.serialize(testJts);