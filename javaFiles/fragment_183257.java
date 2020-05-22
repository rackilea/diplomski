protected final <T> T with(Matcher<T> argumentMatcher)
   {
      argMatchers.add(argumentMatcher);

      TypeVariable<?> typeVariable = argumentMatcher.getClass().getTypeParameters()[0];

      return (T) Utilities.defaultValueForType(typeVariable.getClass());
   }