public class Enclosing {
    // Make this class here static:
    public static class DOWConverter extends EnumConverter<Integer, DayOfWeek> {
        public DOWConverter() {
            super(Integer.class, DayOfWeek.class);           
        }               
    }
}