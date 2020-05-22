public class DiscScreen extends MainScreen {

   public DiscScreen() {
      super(MainScreen.VERTICAL_SCROLL | MainScreen.VERTICAL_SCROLLBAR);

      add(new DiscManager(Field.USE_ALL_WIDTH));
   }
}