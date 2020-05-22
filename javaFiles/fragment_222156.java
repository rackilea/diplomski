public static <T> ArrayList<T> mySortMethod(T aClass, String sortBy){
      try {
        Field sortByField=aClass.getClass().getField(sortBy); // bombs out if field doesn't exist
        return something like query.from(aClass).orderby(sortByField.getName());
    } catch (NoSuchFieldException e) {
        throw new BlahBlahException ("Field "+sortBy+" isn't a member of class "+aClass.getClass().getName(),e);
   } catch (SecurityException e) {
       throw new BlahBlahException ("Field "+sortBy+" in class "+aClass.getClass().getName()+" is not accessible",e);
    }
  }