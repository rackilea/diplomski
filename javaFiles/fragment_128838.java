public class MyClass implements SearchSuggestion {
    private final String myString;

     public MyClass(String text){
         this.myString = text;
     }

     @Override
     public String getBody() {
          return myString;
     }
}