private Butler<Person> findButler(Person person, Injector injector){
   Class<? extends Person> personClass = person.getClass();

   ParameterizedType parameterizedButler =
   Types.newParameterizedTypeWithOwner(ButlersOuter.class, Butler.class, personClass);

   Key<?> key = Key.get(parameterizedButler);
   Butler<Person> butler = (Butler<Person>) injector.getInstance(key);
   return butler
}