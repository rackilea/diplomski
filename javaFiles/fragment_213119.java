public class Main{
    public static void main(String... args){
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BookService bookService = container.instance().select(BookService.class).get();
        weld.shutdown();
    }
}