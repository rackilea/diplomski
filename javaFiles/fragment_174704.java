interface ToasterProvider{
   /**
    *  @see classPresent(String)
    *  @return return true if the library is presented in classpath
    */
   boolean isPresent();
   /**
    * @throws NoSuchElementException thrown if toaster library is not present
    */
   Toaster toaster() throws NoSuchElementException;
}

List<ToasterProvider>  providers = ...;

Toaster toaster = providers.stream()
                           .filter(ToasterProvider::isPresent)
                           .findFirst().map(ToasterProvider::toaster)
                           .orElse(locally());