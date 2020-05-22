public class HasSublist<T> extends TypeSafeMatcher<T> {

     @Override
      public boolean matchesSafely(List<T> subList) {
        //Logic if sublist exist ...
        return true;
      }

      public static <T> Matcher<T> hasSubList(List<T> containsSublist) {
        return new HasSublist<T>(containsSublist);
      }
}