public class Global extends GlobalSettings {

public void onStart(Application app) {
    Formatters.register(Category.class, new Formatters.SimpleFormatter<Category>() {
        @Override
        public Category parse(String text, Locale locale) throws ParseException {
            return Category.find.byId(Long.parseLong(text));
        }

        @Override
        public String print(Category category, Locale locale) {
            return category.id+"";
        }
    });
}