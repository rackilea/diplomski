public class FigureConverter {

    @ReadingConverter
    public static class GenderConverter implements Converter<String, Gender> {

        @Override
        public Gender convert(final String source) {
            return Gender.fromString(source);
        }
    }

}