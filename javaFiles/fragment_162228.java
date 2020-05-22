public abstract class ClassSelector{
   public final synchronized List<Class<?>> getClassSelection(Class<?> clazz) {
     return getSpecificClasses(clazz);
   }

   protected abstract List<Class<?>> getSpecificClasses(Class<?> clazz);